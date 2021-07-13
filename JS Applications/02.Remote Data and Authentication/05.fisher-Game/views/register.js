import {register} from '../api/userService.js';
import {showHome} from './home.js';

let main;
let section;
let ctx;

export function setupRegister(mainTarget, sectionTarget, context){
    main = mainTarget;
    section = sectionTarget;
    ctx = context;

    section.querySelector('#register').addEventListener('submit', registerUser);

}

export async function showRegister(){
    main.innerHTML = '';
    main.appendChild(section);
}

async function registerUser(ev){
    ev.preventDefault();
    const form = ev.currentTarget;
    const formData = new FormData(form);

    const email = formData.get('email');
    const password = formData.get('password');
    const rePass = formData.get('rePass');

    if(email == '' || password == '' || rePass == ''){
        alert('All fields are required!');
        return;
    }

    if(password !== rePass){
        alert('Passwords don\'t match.');
        return;
    }

    try{
        await register({email, password});
        form.reset();
    } catch(err){
        alert(err.message);
        return;
    }

    showHome();
    ctx.setUserNav();
}