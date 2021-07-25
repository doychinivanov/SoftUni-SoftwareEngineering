import {createFurniture, editFurniture, deleteFurniture} from '../services/furnitureService.js';

export async function deleteRecord(ctx){
    const confirmed = confirm('Are you sure you want to delete this furniture?');

    if(confirmed){
        try{
            await deleteFurniture(ctx.params.id);
            ctx.page.redirect('/');
        } catch (err){
            alert(err.message);
            return;
        }
    }
}

export async function setUpNewRecord(ev, ctx, id){
    ev.preventDefault();

    const form = ev.target;
    const formData = new FormData(form);

    const make = formData.get('make').trim();
    const model = formData.get('model').trim();
    const year = Number(formData.get('year'));
    const description = formData.get('description').trim();
    const price = Number(formData.get('price'));
    const img = formData.get('img').trim();
    const material = formData.get('material').trim();


    if(validateForm({make, model, year, description, price, img, material}, form)){
        try{

            if(form.id == 'edit-form'){
                await editFurniture(id, {make, model, year, description, price, img, material});
                ctx.page.redirect('/details' + `/${id}`);
            } else {
                await createFurniture({make, model, year, description, price, img, material});
                ctx.page.redirect('/');
            }

            form.reset();
        } catch(err){
            alert(err.message);
            return;
        }
    }



    function validateForm(data, form){
        let validForm = true;
    
        if(data.make.length < 4){
            validForm = false;
            form.querySelector('input[name=make]').classList.remove('is-valid');
    
            form.querySelector('input[name=make]').classList.add('is-invalid');
    
            addMessage('Make must be at least 4 symbols long', form.querySelector('label[for=new-make]'));
        } else {
            validateForm = true;
            removeMsg(form.querySelector('label[for=new-make]'));

            form.querySelector('input[name=make]').classList.remove('is-invalid');
    
            form.querySelector('input[name=make]').classList.add('is-valid');
        }

        if(data.model.length < 4){
            validForm = false;

            form.querySelector('input[name=model]').classList.remove('is-valid');
            form.querySelector('input[name=model]').classList.add('is-invalid');

            addMessage('Model must be at least 4 symbols long', form.querySelector('label[for=new-model]'));

        } else {
            validateForm = true;
            removeMsg(form.querySelector('label[for=new-model]'));

            form.querySelector('input[name=model]').classList.remove('is-invalid');
            form.querySelector('input[name=model]').classList.add('is-valid');
        }
    
        if(data.year < 1950 || data.year > 2050){
            validForm = false;
    
            form.querySelector('input[name=year]').classList.remove('is-valid');
    
            form.querySelector('input[name=year]').classList.add('is-invalid');

            addMessage('Year must be between 1950 and 2050', form.querySelector('label[for=new-year]'));

        } else {
            validateForm = true;
            removeMsg(form.querySelector('label[for=new-year]'));
    
            form.querySelector('input[name=year]').classList.remove('is-invalid');
    
            form.querySelector('input[name=year]').classList.add('is-valid');
    
    
        }
    
        if(data.description.length < 10){
            validForm = false;
    
            form.querySelector('input[name=description]').classList.remove('is-valid');
    
            form.querySelector('input[name=description]').classList.add('is-invalid');
    
            addMessage('Description must be more than 10 symbols', form.querySelector('label[for=new-description]'));
        } else {
            validateForm = true;
            removeMsg(form.querySelector('label[for=new-description]'));
    
            form.querySelector('input[name=description]').classList.remove('is-invalid');
    
            form.querySelector('input[name=description]').classList.add('is-valid');
        }
    
        if(!data.price || data.price < 0){
            validForm = false;
    
            form.querySelector('input[name=price]').classList.remove('is-valid');
    
            form.querySelector('input[name=price]').classList.add('is-invalid');
    
            addMessage('Price must be a positive number', form.querySelector('label[for=new-price]'));
        } else {
            validateForm = true;
            removeMsg(form.querySelector('label[for=new-price]'));
    
            form.querySelector('input[name=price]').classList.remove('is-invalid');
    
            form.querySelector('input[name=price]').classList.add('is-valid');
        }
    
        if(data.img == ''){
            validForm = false;
    
            form.querySelector('input[name=img]').classList.remove('is-valid');
    
            form.querySelector('input[name=img]').classList.add('is-invalid');
    
            addMessage('Image URL is required', form.querySelector('label[for=new-image]'));
        } else {
            validateForm = true;
            removeMsg(form.querySelector('label[for=new-image]'));
    
            form.querySelector('input[name=img]').classList.remove('is-invalid');
    
            form.querySelector('input[name=img]').classList.add('is-valid');
        }
    
        return validForm;
    }

    function addMessage(msg, label){

        if([...label.children].length == 0){
            const span = document.createElement('span');
            span.classList.add('error-msg')
            span.textContent = msg;
    
            label.appendChild(span);
        }
        
    }

    function removeMsg(label){
        const span = label.querySelector('.error-msg');

        if(span){
            label.removeChild(label.querySelector('.error-msg'));
        }
    }
}