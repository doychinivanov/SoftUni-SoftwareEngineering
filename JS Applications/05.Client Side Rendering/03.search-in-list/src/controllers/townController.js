import {render} from 'https://unpkg.com/lit-html?module';
import {ulTemplate} from '../views/townsTemp.js';
import { resultTemplate } from '../views/resultTemplate.js';
import {towns} from '../services/towns.js';
import {input, root, button, result} from '../util/setDomElements.js';

function search(ev){
    if(input.value == '') return;

    const query = input.value;
    update(query);
    render(resultTemplate(countMatches(towns, query)), result);

    function countMatches(towns,query){
        const matches = towns.filter(t => query && t.toLowerCase().includes(query.toLowerCase())).length;
     
        if(matches == 1){
           return `${matches} match found`
        } else if(matches == 0){
           return `No matches found!`
        } else {
           return `${matches} matches found.`
        }
     }
}

export function loadTowns() {
    update();

    button.addEventListener('click', search)
}

function update(query = ''){
    render(ulTemplate(towns, query), root);
}