import { getTableData } from "../api/tableService.js";
import {render} from 'https://unpkg.com/lit-html?module';
import { tableTemplate } from "../views/tableTemplate.js";

const ctx = {};

export async function loadTableData(){
    try{
        const data = await getTableData();
        ctx.people = Object.values(data);
        update(ctx.people);
    } catch(err){
        alert(err.message);
        return;
    }
}

export async function search(ev){
    const input = ev.target.previousElementSibling;

    const query = input.value;

    if(query == '') return;

    update(ctx.people, query);

    input.value = '';

}

function update(data, query = ''){
    render(tableTemplate(data, query), document.querySelector('.container'));
}