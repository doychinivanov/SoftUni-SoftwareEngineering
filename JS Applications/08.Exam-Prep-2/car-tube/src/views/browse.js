import { html } from '../config/libraries.js';

const browseTemplate = (allCars) => html`
<section id="car-listings">
    <h1>Car Listings</h1>
    <div class="listings">

        ${allCars.length > 0 ? allCars.map(oneCarTemplate) : html`<p class="no-cars">No cars in database.</p>`}

    </div>
</section>
`;

const oneCarTemplate = (car) => html`
    <div class="listing">
        <div class="preview">
            <img src="${car.imageUrl}">
        </div>
        <h2>${car.brand} ${car.model}</h2>
        <div class="info">
            <div class="data-info">
                <h3>Year: ${car.year}</h3>
                <h3>Price: ${car.price} $</h3>
            </div>


            <div class="data-buttons">
                <a href="/details/${car._id}" class="button-carDetails">Details</a>
            </div>
        </div>
    </div>
`;

export const showAll = async (ctx) => {
    const allCars = await ctx.storage.getAllCarsSorted();
    ctx.render(browseTemplate(allCars));
    ctx.setUserNav();
}