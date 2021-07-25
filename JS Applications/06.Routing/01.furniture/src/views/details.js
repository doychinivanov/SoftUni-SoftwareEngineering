import { html } from '../config/libraries.js';
import { getFurnitureById } from '../services/furnitureService.js';


const detailTemplate = (currentFurniture) => html`
<div class="container">
    <div class="row space-top">
        <div class="col-md-12">
            <h1>Furniture Details</h1>
        </div>
    </div>
    <div class="row space-top">
        <div class="col-md-4">
            <div class="card text-white bg-primary">
                <div class="card-body">
                    <img src="${currentFurniture.img[0] == '.' ? currentFurniture.img.substring(1) : currentFurniture.img}" />
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <p>Make: <span>${currentFurniture.make}</span></p>
            <p>Model: <span>${currentFurniture.model}</span></p>
            <p>Year: <span>${currentFurniture.year}</span></p>
            <p>Description: <span>${currentFurniture.description}</span></p>
            <p>Price: <span>${currentFurniture.price}</span></p>
            <p>Material: <span>${currentFurniture.material}</span></p>

            ${currentFurniture._ownerId == sessionStorage.getItem('userId')
             ? html`<div>
                <a href="/edit/${currentFurniture._id}" class="btn btn-info">Edit</a>
                <a href="/delete/${currentFurniture._id}" class="btn btn-red">Delete</a>
            </div>` 
             : ''}
        </div>
    </div>
</div>
`;

export const showDetails = async (ctx) =>{
    const id = ctx.params.id;
    const currentFurniture = await getFurnitureById(id);

    ctx.render(detailTemplate(currentFurniture));
    ctx.setUserNav();
}