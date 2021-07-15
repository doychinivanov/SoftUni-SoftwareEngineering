import {showDetails} from './details.js'

let main;
let section;

export function setupCreate(mainTarget, sectionTarget){
    main = mainTarget;
    section = sectionTarget;

    section.querySelector('form').addEventListener('submit', onCreateNewMovie)
}


export async function showCreate(){
    main.innerHTML = '';
    main.appendChild(section);
}

async function onCreateNewMovie(event){
    event.preventDefault();
    const formData = new FormData(event.target);
    const title = formData.get('title');
    const description = formData.get('description');
    const img = formData.get('imageUrl');

    if(title == '' || description == '' || img == ''){
        return alert('All fields are requried!')
    }

    const response = await fetch('http://localhost:3030/data/movies',{
        method: 'post',
        headers: {'Content-Type': 'application/json', 'X-Authorization': sessionStorage.getItem('userToken')},
        body: JSON.stringify({title, description, img})
    })

    if (!response.ok) {
        const error = await response.json();
        alert(error.message);
        throw new Error(error.message)
    }

    const movie = await response.json();
    showDetails(movie._id);
}