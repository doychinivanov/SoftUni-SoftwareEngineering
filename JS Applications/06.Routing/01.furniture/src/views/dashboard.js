import { html } from '../config/libraries.js';
import { getAllFurniture } from '../services/furnitureService.js';

const dashboardTemplate = (allFurniture) => html`
    <div class="container">
        <div class="row space-top">
            <div class="col-md-12">
                <h1>Welcome to Furniture System</h1>
                <p>Select furniture from the catalog to view details.</p>
            </div>
        </div>
        <div class="row space-top">

            ${allFurniture.map(currentFurniture)}

        </div>
    </div>
`;

const currentFurniture = (furniture) => html`
<div class="col-md-4">
    <div class="card text-white bg-primary">
        <div class="card-body">
            <img src="${furniture.img}" />
            <p>Description here</p>
            <footer>
                <p>Price: <span>${furniture.price} $</span></p>
            </footer>
            <div>
                <a href="/details/${furniture._id}" class="btn btn-info">Details</a>
            </div>
        </div>
    </div>
</div>
`;

export const showDashboard = async (ctx) => {
    const allFurniture = await getAllFurniture();
    ctx.render(dashboardTemplate(allFurniture));
    ctx.setUserNav();
}