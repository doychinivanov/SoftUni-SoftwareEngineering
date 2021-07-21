import {render} from 'https://unpkg.com/lit-html?module';
import { ulTemplate } from '../views/townTemplate.js';
import { root } from '../util/domElements.js';

export async function createTownList(ev){
    ev.preventDefault();

    const form = ev.currentTarget;
    const formData = new FormData(form);
    const towns = formData.get('towns').split(', ');
    
    render(ulTemplate(towns), root);

    form.reset();
}