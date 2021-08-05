import { html } from '../config/libraries.js';
import { deleteCarRecord } from '../controllers/carController.js';

const detailtTemplate = (ctx, car) => html`
    <section id="listing-details">
        <h1>Details</h1>
        <div class="details-info">
            <img src="${car.imageUrl}">
            <hr>
            <ul class="listing-props">
                <li><span>Brand:</span>${car.brand}</li>
                <li><span>Model:</span>${car.model}</li>
                <li><span>Year:</span>${car.year}</li>
                <li><span>Price:</span>${car.price}$</li>
            </ul>
    
            <p class="description-para">${car.description}</p>
    
            ${car._ownerId == sessionStorage.getItem('userId') ? html`<div class="listings-buttons">
                <a href="/edit/${car._id}" class="button-list">Edit</a>
                <a @click=${(ev) => deleteCarRecord(ev, ctx, car._id)} href="javascript:void(0)" class="button-list">Delete</a>
            </div>` : ''}
        </div>
    </section>
`;

export const showDetails = async (ctx) => {
    const currentCar = await ctx.storage.getCarById(ctx.params.id);

    ctx.render(detailtTemplate(ctx, currentCar));
    ctx.setUserNav();
}