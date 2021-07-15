import {showHome} from './home.js'
import {extractNameFromEmail} from '../util/emailParser.js';
import {login} from '../api/userService.js';

let main;
let section;
let ctx;

export function setupLogin(mainTarget, sectionTarget, context){
    main = mainTarget;
    section = sectionTarget;
    ctx = context;

    section.querySelector('form').addEventListener('submit', loginUser)
}


export async function showLogin(){
    main.innerHTML = '';
    main.appendChild(section);
}

async function loginUser(event){
    event.preventDefault();
    const formData = new FormData(event.target);
    const email = formData.get('email');
    const password = formData.get('password');

    if(email === '' || password === ''){
        return alert('All fields are required!')
    }

    try{
        await login({email, password});
    } catch(err){
        alert(err.message);
        return;
    }

    event.target.reset();
    ctx.setUserNav();
    showHome();
}