import { html } from "../config/libraries.js";

const myBooksTemplate = (books) => html`
<section id="my-books-page" class="my-books">
    <h1>My Books</h1>
    <!-- Display ul: with list-items for every user's books (if any) -->

    ${books.length > 0 ? html`<ul class="my-books-list">
        ${books.map(bookTemplate)}
    </ul>` : html`<p class="no-books">No books in database!</p>`} 
    
</section>
`;

const bookTemplate = (book) => html`
<li class="otherBooks">
            <h3>${book.title}</h3>
            <p>Type: ${book.type}</p>
            <p class="img"><img src="${book.imageUrl}"></p>
            <a class="button" href="/details/${book._id}">Details</a>
</li>
`;

export const showMyBooks = async (ctx) => {
    const books = await ctx.storage.getBooksByUserId(sessionStorage.getItem('userId'));
    ctx.render(myBooksTemplate(books));
}