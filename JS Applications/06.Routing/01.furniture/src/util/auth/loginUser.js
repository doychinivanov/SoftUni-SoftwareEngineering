import {login} from '../../services/userService.js';

export const loginUser = async (ev, ctx) =>{
    ev.preventDefault();
    const form = ev.target;

    const formData = new FormData(form);

    const email = formData.get('email');
    const password = formData.get('password');

    if(email == '' || password == ''){
        alert('All fields are required!');
        return;
    }

    try{
        await login({email, password});
    } catch(err){
        alert(err.message);
        return;
    }

    ctx.setUserNav();
    ctx.page.redirect('/');
}