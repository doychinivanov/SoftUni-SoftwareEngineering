import * as elements from './util/setDomElements.js';
import {setupHome, showHome } from './views/home.js';


setupSection('home', setupHome);
showHome();

function setupSection(sectionId, setup) {
    const section = document.getElementById(sectionId);
    setup(elements.main, section);
}