import { html } from '../config/libraries.js';
import { findCar } from '../controllers/carController.js';

const state = {
    cars: [],
    hasBeenSearched: false
}

const searchTemplate = (ctx) => html`
    <section id="search-cars">
        <h1>Filter by year</h1>

        <div class="container">
            <input id="search-input" type="text" name="search" placeholder="Enter desired production year">
            <button @click=${(ev) => findCar(ev, ctx, state, searchTemplate)} class="button-list">Search</button>
        </div>
    
        <h2>Results:</h2>
        <div class="listings">
    
        ${state.hasBeenSearched ? state.cars.length > 0 ? state.cars.map(oneCarTemplate) : html`<p class="no-cars"> No results.</p>` : ''}
        <!-- ${state.cars.length > 0 ? state.cars.map(oneCarTemplate) : html`<p class="no-cars"> No results.</p>`} -->
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

export const showSearch = (ctx) => {
    ctx.render(searchTemplate(ctx));
    ctx.setUserNav();
}