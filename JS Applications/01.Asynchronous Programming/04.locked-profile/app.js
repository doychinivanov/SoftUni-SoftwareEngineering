import {getAllUsers} from './src/api.js';
import { holder } from './views/profileView.js';
import {render} from './node_modules/lit-html/lit-html.js';

lockedProfile();

async function lockedProfile() {
    const main = document.getElementById('main');
    const users = await getAllUsers();

    render(holder(users), main);
}