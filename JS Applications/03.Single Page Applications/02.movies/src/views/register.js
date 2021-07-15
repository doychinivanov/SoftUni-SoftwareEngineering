import {showHome} from './home.js'
import {extractNameFromEmail} from '../util/emailParser.js';
import {register} from '../api/userService.js';

let main;
let section;
let ctx;

export function setupRegister(mainTarget, sectionTarget, context){
    main = mainTarget;
    section = sectionTarget;
    ctx = context;

    section.querySelector('form').addEventListener('submit', onRegister)
}


export async function showRegister(){
    main.innerHTML = '';
    main.appendChild(section);
}

async function onRegister(event){
    event.preventDefault();
    const formData = new FormData(event.target);
    const email = formData.get('email');
    const password = formData.get('password');
    const rePass = formData.get('repeatPassword');

    if(email === '' || password === '' || rePass === ''){
        return alert('All fields are required!')
    }

    if(password !== rePass){
        return alert('Passwords don\'t match');
    }

    try{
        await register({email, password});
    } catch(err){
        alert(err.message);
        return;
    }

    ctx.setUserNav();
    showHome();
}