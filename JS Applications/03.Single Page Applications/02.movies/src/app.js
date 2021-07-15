import { setupHome, showHome } from './views/home.js'
import { setupDetails } from './views/details.js';
import { setupLogin, showLogin } from './views/login.js'
import { setupRegister, showRegister } from './views/register.js'
import { setupCreate, showCreate } from './views/create.js'
import { setupEdit } from './views/edit.js'
import {extractNameFromEmail} from './util/emailParser.js';
import { logout } from './api/userService.js';

// grab sections
const main = document.querySelector('main');
const ctx = {setUserNav}

const links = {
    'homeLink': showHome,
    'loginLink': showLogin,
    'registerLink': showRegister,
    'createLink': showCreate
}

setupSection('home-page', setupHome);
setupSection('add-movie', setupCreate);
setupSection('movie-details', setupDetails);
setupSection('edit-movie', setupEdit);
setupSection('form-login', setupLogin, ctx);
setupSection('form-sign-up', setupRegister, ctx);

setupNavigation();
//Start application in home view
showHome();

function setupSection(sectionId, setup, ctx) {
    const section = document.getElementById(sectionId);
    setup(main, section, ctx);
}

function setUserNav(){
    const email = sessionStorage.getItem('email');

    if (email != null) {
        document.getElementById('welcome-msg').textContent = `Welocme ${extractNameFromEmail(email)}`;


        [...document.querySelectorAll('nav .user')].forEach(l => l.style.display = 'block');
        [...document.querySelectorAll('nav .guest')].forEach(l => l.style.display = 'none');

    } else {
        [...document.querySelectorAll('nav .user')].forEach(l => l.style.display = 'none');
        [...document.querySelectorAll('nav .guest')].forEach(l => l.style.display = 'block');

    }
}

function setupNavigation() {
    setUserNav();

    document.querySelector('nav').addEventListener('click', async (ev) => {
        if (ev.target.id === 'logoutLink') {
            await logout();
            setUserNav();
            showLogin();
        }
    })

    document.querySelector('nav').addEventListener('click', (event) => {
        const view = links[event.target.id];
        if (typeof view === 'function') {
            event.preventDefault();
            view();
        }
    });

    document.getElementById('createLink').addEventListener('click', (event) => {
        event.preventDefault();
        showCreate();
    })

}