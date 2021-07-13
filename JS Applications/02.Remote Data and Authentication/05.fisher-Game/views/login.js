import { login } from "../api/userService.js";
import {showHome} from './home.js';

let main;
let section;
let ctx;

export function setupLogin(mainTarget, sectionTarget, context){
    main = mainTarget;
    section = sectionTarget;
    ctx= context;

    section.querySelector('#login').addEventListener('submit', loginUser);

}

export async function showLogin(){
    main.innerHTML = '';
    main.appendChild(section);
}

async function loginUser(ev){
    ev.preventDefault();
    const form = ev.currentTarget;
    const formData = new FormData(form);

    const email = formData.get('email');
    const password = formData.get('password');

    if(email == '' || password == ''){
        alert('All fields are required!');
        return;
    }

    try{
        await login({email, password});
        form.reset();
    } catch(err){
        alert(err.message);
        return;
    }

    showHome();
    ctx.setUserNav();
}