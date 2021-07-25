import {register} from '../../services/userService.js';

export const registerUser = async (ev, ctx) => {
    ev.preventDefault();
    const form = ev.target;

    const formData = new FormData(form);

    const email = formData.get('email');
    const password = formData.get('password');
    const rePass = formData.get('rePass');

    if(email == '' || password == ''){
        alert('All fields are required!');
        return;
    }
    
    if(password.length < 4){
        alert('Password must be at leas 4 characters long!');
        return;
    }
    
    if(password != rePass){
        alert('Passwords do not match!');
        return;
    }


    try{
        await register({email, password});
    } catch(err){
        alert(err.message);
        return;
    }

    ctx.setUserNav();
    ctx.page.redirect('/');
}