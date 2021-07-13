import * as elements from './util/setDomElements.js';
import { setupHome, showHome } from './views/home.js';
import {setupLogin, showLogin} from './views/login.js';
import { setupRegister, showRegister } from './views/register.js';
import { logout } from './api/userService.js';
import {extractNameFromEmail} from './util/emailParser.js';

const ctx = {
    setUserNav
}

const routes = {
    '/': showHome,
    '/login': showLogin,
    '/register': showRegister
}

setupSection('home-view', setupHome)
setupSection('login-view', setupLogin);
setupSection('register-view', setupRegister);

startApp();
setUserNav();

function startApp(){
    showHome();

    elements.navLinks.forEach(a => a.addEventListener('click', navigate));
    elements.navLinks.find(a => a.id == 'home').classList.add('active');
}

async function navigate(ev){
    ev.preventDefault();

    setActiveLink(elements.navLinks, ev.target);

    if(ev.target.id == 'logout'){
        await logout();
        showHome();
        setUserNav();
        return;
    }
    const view = routes[ev.target.pathname];
    view();
}

function setupSection(sectionId, setup) {
    const section = document.getElementById(sectionId);
    setup(elements.main, section, ctx);
}

function setUserNav(){
    const email = sessionStorage.getItem('email');

    if (email != null) {
        document.getElementById('welcome-msg').textContent = `${extractNameFromEmail(email)}`;


        document.querySelector('nav #user').style.display = 'block';
        document.querySelector('nav #guest').style.display = 'none';

    } else {
        document.getElementById('welcome-msg').textContent = 'guest';
        document.querySelector('nav #user').style.display = 'none';
        document.querySelector('nav #guest').style.display = 'block';
    }
}

function setActiveLink(links, current){
    links.forEach(link => link.classList.remove('active'));
    current.classList.add('active');
}