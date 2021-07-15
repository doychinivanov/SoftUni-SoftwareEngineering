import { showHome } from "./home.js";
import { showEdit } from "./edit.js";

async function getLikesByMovieId(id) {
    const response = await fetch(`http://localhost:3030/data/likes?where=movieId%3D%22${id}%22&distinct=_ownerId&count`);

    if (!response.ok) {
        const error = await response.json();
        alert(error.message);
        throw new Error(error.message)
    }
    const data = await response.json();

    return data;
}

async function getOwnLikesByMovieId(id) {
    const userId = sessionStorage.getItem('userId');
    const response = await fetch(`http://localhost:3030/data/likes?where=movieId%3D%22${id}%22%20and%20_ownerId%3D%22${userId}%22 `);

    if (!response.ok) {
        const error = await response.json();
        alert(error.message);
        throw new Error(error.message)
    }
    const data = await response.json();

    return data;
}


async function getMovieById(id) {
    const response = await fetch('http://localhost:3030/data/movies/' + id);

    if (!response.ok) {
        const error = await response.json();
        alert(error.message);
        throw new Error(error.message)
    }
    const data = await response.json();

    return data;
}

function createMovieCard(movie, likes, ownlike) {
    const userId = sessionStorage.getItem('userId');
    const controls = [];

    if (userId != null) {
        if (userId == movie._ownerId) {
            controls.push('<a class="btn btn-danger" href="#">Delete</a>');
            controls.push('<a class="btn btn-warning" href="#">Edit</a>');
        } else if(ownlike.length == 0) {
            controls.push('<a class="btn btn-primary" href="#">Like</a>');
        }
    }
    controls.push(`<span class="enrolled-span">${likes} likes</span>`);


    const element = document.createElement('div');
    element.className = 'container';
    element.innerHTML = `
    <div class="row bg-light text-dark">
        	<h1>Movie title: ${movie.title}</h1>

        <div class="col-md-8">
            <img class="img-thumbnail"
            src="${movie.img}" alt="Movie">
        </div>
        <div class="col-md-4 text-center">
            <h3 class="my-3 ">Movie Description</h3>
            <p>${movie.description}</p>
            ${controls.join('')}
        </div>
    </div>`

    element.addEventListener('click', async (ev) => {
        ev.preventDefault();
        if (ev.target.classList.contains('btn')) {
            if (ev.target.textContent === 'Like') {
                await likeMovie(ev);
            } else if (ev.target.textContent === 'Delete') {
                const confirmed = confirm('Are you sure you want to delete this movie?');
                if(confirmed){
                    await deleteMovie(movie._id);
                    showHome();
                }
            } else if (ev.target.textContent === 'Edit') {
                showEdit(movie);
            }
        }
    })

    return element;

    async function likeMovie(event) {
        const response = await fetch('http://localhost:3030/data/likes', {
            method: 'post',
            headers: {
                'Content-Type': 'application/json',
                'X-Authorization': sessionStorage.getItem('userToken')
            },
            body: JSON.stringify({ movieId: movie._id })
        })

        if (response.ok) {
            event.target.remove();
            likes++;
            showDetails(movie._id)
        }
    }


    async function deleteMovie(id){
        const response = await fetch('http://localhost:3030/data/movies/' + id, {
            method: 'delete',
            headers: {
                'Content-Type': 'application/json',
                'X-Authorization': sessionStorage.getItem('userToken')
            }
        })

        if (!response.ok) {
            const error = await response.json();
            alert(error.message);
            throw new Error(error.message)
        }
    }
}

let main;
let section;

export function setupDetails(mainTarget, sectionTarget) {
    main = mainTarget;
    section = sectionTarget;
}


export async function showDetails(id) {
    main.innerHTML = '';
    main.appendChild(section);

    const [movie, likes, ownlike] = await Promise.all(
        [getMovieById(id),
        getLikesByMovieId(id),
        getOwnLikesByMovieId(id)
        ]);
    const card = createMovieCard(movie, likes, ownlike);
    section.innerHTML = '';
    section.appendChild(card);

}