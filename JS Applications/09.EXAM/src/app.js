import {page} from './config/libraries.js';

import {logout} from './services/userService.js'
import {decorateCtx} from './middlewares/decorateCtx.js';
import { authMiddleware } from './middlewares/auth.js';
import { storageMiddleware } from './middlewares/storage.js';

import { showHome } from './views/home.js';
import {showLogin} from './views/login.js';
import {showRegister} from './views/register.js';
import { showCreate } from './views/create.js';
import { showDetails } from './views/details.js';
import { showEdit } from './views/edit.js';
import {showMyBooks} from './views/myBooks.js';


startApplication();

function startApplication(){
    page('/', decorateCtx, storageMiddleware, showHome);
    page('/login', decorateCtx, authMiddleware, showLogin);
    page('/register', decorateCtx, authMiddleware, showRegister);
    page('/create', decorateCtx, storageMiddleware, showCreate);

    page('/edit/:id', decorateCtx, storageMiddleware, showEdit);
    page('/details/:id', decorateCtx, storageMiddleware, showDetails);
    page('/myBooks', decorateCtx, storageMiddleware, showMyBooks);

    page.start();

    document.getElementById('logoutBtn').addEventListener('click', async ()=>{ await logout(); page.redirect('/') });
}