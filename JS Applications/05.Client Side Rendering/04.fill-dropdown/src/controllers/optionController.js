import {render} from 'https://unpkg.com/lit-html?module';
import {getOptions, createOption} from '../api/optionService.js';
import {optionsTemplate} from '../views/optionsTemplate.js';


export async function loadOptions(){
    try{
        const data = await getOptions();
        const options = Object.values(data);
        update(options);
    } catch(err){
        alert(err.message);
        return;
    }
    

    document.querySelector('form').addEventListener('submit', createOptionRecord);
}

async function createOptionRecord(ev){
    ev.preventDefault();

    const form = ev.currentTarget;

    const formData = new FormData(form);

    const optionText = formData.get('text');

    try{
        await createOption({text: optionText});
    } catch(err){
        alert(err.message);
        return;
    }


    await loadOptions();

    form.reset();
}

function update(options){
    render(optionsTemplate(options), document.getElementById('menuHolder'));
}