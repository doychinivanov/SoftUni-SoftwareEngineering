import { page } from "./config/libraries.js";

import {decorateCtx} from './middlewares/decorateCtx.js';
import { authMiddleware } from './middlewares/auth.js';
import {storageMiddleware} from './middlewares/storage.js';

import {showLogin} from './views/login.js'
import {showHome} from './views/home.js';
import {showRegister} from './views/regiser.js';
import {showAll} from './views/browse.js';
import {showCreate} from './views/create.js';
import {showEdit} from './views/edit.js'
import {showDetails} from './views/details.js';
import {showMyList} from './views/myList.js';
import {showSearch} from './views/search.js';

startApplication();

function startApplication(){
    page('/', decorateCtx, showHome);
    page('/login', decorateCtx, authMiddleware, showLogin);
    page('/register', decorateCtx, authMiddleware, showRegister);
    page('/browse', decorateCtx, storageMiddleware, showAll);
    page('/create', decorateCtx, storageMiddleware, showCreate);

    page('/edit/:id', decorateCtx, storageMiddleware, showEdit);
    page('/details/:id', decorateCtx, storageMiddleware, showDetails);
    page('/myList', decorateCtx, storageMiddleware, showMyList);
    page('/search', decorateCtx, storageMiddleware, showSearch);

    page.start();
}