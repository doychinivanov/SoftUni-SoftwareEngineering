import {createFurniture} from '../services/furnitureService.js';

export async function createNewRecord(ev, ctx){
    ev.preventDefault();

    const form = ev.target;
    const formData = new FormData(form);

    const make = formData.get('make');
    const model = formData.get('model');
    const year = Number(formData.get('year'));
    const description = formData.get('description');
    const price = Number(formData.get('price'));
    const img = formData.get('img');
    const material = formData.get('material');


    if(validateForm({make, model, year, description, price, img, material}, form)){
        console.log('valiiid');
    }

    // form.reset();


    function validateForm(data, form){
        let validForm = true;
    
        if(data.make.length < 4){
            validForm = false;
            form.querySelector('input[name=make]').classList.remove('is-valid');
    
            form.querySelector('input[name=make]').classList.add('is-invalid');
    
            // alert('Make and Model must be at least 4 symbols long');
        } else {
            validateForm = true;
            form.querySelector('input[name=make]').classList.remove('is-invalid');
    
            form.querySelector('input[name=make]').classList.add('is-valid');
        }

        if(data.model.length < 4){
            validForm = false;

            form.querySelector('input[name=model]').classList.remove('is-valid');
            form.querySelector('input[name=model]').classList.add('is-invalid');

            // alert('Make and Model must be at least 4 symbols long');
        } else {
            validateForm = true;
            
            form.querySelector('input[name=model]').classList.remove('is-invalid');
            form.querySelector('input[name=model]').classList.add('is-valid');
        }
    
        if(data.year < 1950 || data.year > 2050){
            validForm = false;
    
            form.querySelector('input[name=year]').classList.remove('is-valid');
    
            form.querySelector('input[name=year]').classList.add('is-invalid');
    
            // alert('Year must be between 1950 and 2050');
        } else {
            validateForm = true;
    
            form.querySelector('input[name=year]').classList.remove('is-invalid');
    
            form.querySelector('input[name=year]').classList.add('is-valid');
    
    
        }
    
        if(data.description.length < 10){
            validForm = false;
    
            form.querySelector('input[name=description]').classList.remove('is-valid');
    
            form.querySelector('input[name=description]').classList.add('is-invalid');
    
            // alert('Description must be more than 10 symbols');
        } else {
            validateForm = true;
    
            form.querySelector('input[name=description]').classList.remove('is-invalid');
    
            form.querySelector('input[name=description]').classList.add('is-valid');
        }
    
        if(!data.price || data.price < 0){
            validForm = false;
    
            form.querySelector('input[name=price]').classList.remove('is-valid');
    
            form.querySelector('input[name=price]').classList.add('is-invalid');
    
            // alert('Price must be a positive number');
        } else {
            validateForm = true;
    
            form.querySelector('input[name=price]').classList.remove('is-invalid');
    
            form.querySelector('input[name=price]').classList.add('is-valid');
        }
    
        if(data.img == ''){
            validForm = false;
    
            form.querySelector('input[name=img]').classList.remove('is-valid');
    
            form.querySelector('input[name=img]').classList.add('is-invalid');
    
            // alert('Image URL is required');
        } else {
            validateForm = true;
    
            form.querySelector('input[name=img]').classList.remove('is-invalid');
    
            form.querySelector('input[name=img]').classList.add('is-valid');
        }
    
        return validForm;
    }
}

