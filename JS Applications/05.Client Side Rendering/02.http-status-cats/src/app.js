import { render } from 'https://unpkg.com/lit-html?module';
import { cats } from "./services/catSeeder.js";
import {ulTemplate} from './views/catTemplate.js';
import {showDetails} from './util/showDetails.js';

showCats();

function showCats(){
    render(ulTemplate(cats), document.getElementById('allCats'));
}

document.getElementById('allCats').addEventListener('click', showDetails)