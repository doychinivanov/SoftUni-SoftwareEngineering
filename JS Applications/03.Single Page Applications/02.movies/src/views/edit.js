import {showDetails} from './details.js'

let main;
let section;

export function setupEdit(mainTarget, sectionTarget){
    main = mainTarget;
    section = sectionTarget;
}


export async function showEdit(movie){
    main.innerHTML = '';
    main.appendChild(section);
    const titleHolder = section.querySelector('input[name="title"]');
    const descriptionHolder = section.querySelector('textarea[name="description"]');
    const imgHolder = section.querySelector('input[name="imageUrl"]');

    titleHolder.value = movie.title;
    descriptionHolder.value = movie.description;
    imgHolder.value = movie.img;
    
    section.querySelector('form').addEventListener('submit', async (ev)=>{
        ev.preventDefault();

        const formData = new FormData(ev.target);
        const title = formData.get('title');
        const description = formData.get('description');
        const img = formData.get('imageUrl');

        const response = await fetch('http://localhost:3030/data/movies/' + movie._id, {
            method: 'put',
            headers: {
                'Content-Type': 'application/json',
                'X-Authorization': sessionStorage.getItem('userToken')
            },
            body: JSON.stringify({title, description, img})
        })

        if (!response.ok) {
            const error = await response.json();
            alert(error.message);
            throw new Error(error.message)
        }

        showDetails(movie._id);
    })
}