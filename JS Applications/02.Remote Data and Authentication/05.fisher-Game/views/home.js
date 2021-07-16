import { html, render } from 'https://unpkg.com/lit-html?module';
import { getCatches, createCatchRecord, deleteCatchRecord, editCatchRecord } from '../api/catchesService.js';

let main;
let section;

export function setupHome(mainTarget, sectionTarget) {
    main = mainTarget;
    section = sectionTarget;

    section.querySelector('.load').addEventListener('click', loadCatches);
    section.querySelector('#addForm').addEventListener('submit', createCatch);

}

export async function showHome() {
    main.innerHTML = '';
    main.appendChild(section);

    if (sessionStorage.getItem('email') == null) {
        section.querySelector('.add').disabled = true;
    } else {
        section.querySelector('.add').disabled = false;
    }
}

async function createCatch(ev){
    ev.preventDefault();
    const form = ev.currentTarget;

    const formData = new FormData(form);

    const angler = formData.get('angler').trim();
    const weight = Number(formData.get('weight').trim());
    const species = formData.get('species').trim();
    const location = formData.get('location').trim();
    const bait = formData.get('bait'.trim());
    const captureTime = Number(formData.get('captureTime').trim());

    if(angler == '' || weight == '' || species == '' || location == '' || bait == '' || captureTime == ''){
        alert('All fields are required!');
        return;
    }

    try{
        await createCatchRecord({angler, weight, species, location, bait, captureTime});
        await loadCatches();
        form.reset();
    } catch(err){
        alert(err.message);
        return;
    }
}

async function updateCatch(ev){
    const currentCatchElement = ev.target.parentNode;
    const id = ev.target.getAttribute('data-id');

    const angler = currentCatchElement.querySelector('.angler').value.trim();
    const weight = Number(currentCatchElement.querySelector('.weight').value.trim());
    const species = currentCatchElement.querySelector('.species').value.trim();
    const location = currentCatchElement.querySelector('.location').value.trim();
    const bait = currentCatchElement.querySelector('.bait').value.trim();
    const captureTime = Number(currentCatchElement.querySelector('.captureTime').value.trim());

    if(angler == '' || weight == '' || species == '' || location == '' || bait == '' || captureTime == ''){
        alert('All fields are required!');
        return;
    }

    try{
        await editCatchRecord(id, {angler, weight, species, location, bait, captureTime});
        await loadCatches();
    } catch(err){
        alert(err.message);
        return;
    }
}

async function deleteCatch(ev){
    const id = ev.target.getAttribute('data-id');

    if(confirm('Are you sure you want to delete this record?')){
        try{
            await deleteCatchRecord(id);
            await loadCatches();
        } catch(err){
            alert(err.message);
            return;
        }
    }
}

async function loadCatches() {
    const data = await getCatches();
    const holder = document.getElementById('main');
    holder.style.display = 'inline-block';

    render(fieldSetTemp(data), holder);
}

const fieldSetTemp = (catches) => html`
    <legend>Catches</legend>
    <div id="catches">
        ${catches.map(catchTemplate)}
    </div>
`;

const catchTemplate = (currentCatch) => html`
<div class="catch">
    <label>Angler</label>
    <input type="text" class="angler" value="${currentCatch.angler}">
    <label>Weight</label>
    <input type="text" class="weight" value="${currentCatch.weight}">
    <label>Species</label>
    <input type="text" class="species" value="${currentCatch.species}">
    <label>Location</label>
    <input type="text" class="location" value="${currentCatch.location}">
    <label>Bait</label>
    <input type="text" class="bait" value="${currentCatch.bait}">
    <label>Capture Time</label>
    <input type="number" class="captureTime" value="${currentCatch.captureTime}">
    ${sessionStorage.getItem('userId') == currentCatch._ownerId ? 
    html `<button @click="${updateCatch}" class="update" data-id="${currentCatch._id}">Update</button>
    <button @click="${deleteCatch}" class="delete" data-id="${currentCatch._id}">Delete</button>` 
    : 
    html` <button disabled class="update" data-id="${currentCatch._id}">Update</button>
    <button disabled class="delete" data-id="${currentCatch._id}">Delete</button>`}
</div>
`;