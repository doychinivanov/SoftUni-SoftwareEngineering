import * as elements from './src/util/setDomElements.js';
import {getBooks, createBook, deleteBook, editBook} from './src/api/bookService.js';
import {createRows} from './src/util/createElements.js';
import {swithViews} from './src/util/swithViews.js';

elements.loadBtn.addEventListener('click', loadBooks);
elements.createForm.addEventListener('submit', createBookRecord);
elements.tbody.addEventListener('click', manipulateBook);

async function loadBooks(){
    const books = await getBooks();

    while(elements.tbody.lastElementChild){
        elements.tbody.removeChild(elements.tbody.lastElementChild);
    };
    
    Object
    .entries(books)
    .map(book => ({_id: book[0], author: book[1].author, title: book[1].title}))
    .map(x => createRows(x))
    .forEach(row => elements.tbody.appendChild(row));
};

async function createBookRecord(ev){
    ev.preventDefault();
    const form = ev.currentTarget;

    const formData = new FormData(form);
    const author = formData.get('author');
    const title = formData.get('title');

    if(author == '' || title == ''){
        return alert('All fields are required.');
    };

    await createBook({author, title});
    loadBooks();

    form.reset();
};

async function editBookRecord(ev){
    ev.preventDefault();

    const form = ev.currentTarget;

    const formData = new FormData(form);

    const newAuthor = formData.get('author');
    const newTitle = formData.get('title');
    const bookId = ev.target.querySelector('button').getAttribute('data-id');
    
    await editBook(bookId, {author:newAuthor, title: newTitle});
    form.reset();
    loadBooks();
    swithViews(elements.createForm, elements.editForm);
}

async function manipulateBook(ev){
    const bookId = ev.target.parentNode.parentNode.id;

    if(ev.target.id == 'delete'){
        await deleteBook(bookId);
        loadBooks();

    } else if(ev.target.id == 'edit'){
        populateEditForm(ev, bookId);

        elements.editForm.addEventListener('click', (ev) => {
            if(ev.target.id == 'cancelBtn'){
                swithViews(elements.createForm, elements.editForm);
            };
        });

        elements.editForm.addEventListener('submit', editBookRecord);
    }

}

function populateEditForm(ev, bookId){
    swithViews(elements.editForm, elements.createForm);

    const tableRow = ev.target.parentNode.parentNode;
    const [title, author] = [...tableRow.querySelectorAll('td')].map(td => td.textContent);

    const titleInput = elements.editForm.querySelector('input[name="title"]');
    const authorInput = elements.editForm.querySelector('input[name="author"]');
    const saveBtn = elements.editForm.querySelector('button');

    saveBtn.setAttribute('data-id', bookId);
    
    titleInput.value = title;
    authorInput.value = author;
}

function swithToCreate(){
    elements.createForm.style.display = 'block';
    elements.editForm.style.display = 'none';
}