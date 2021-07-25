import {page} from './config/libraries.js';
import {decorateCtx} from './middlewares/decorateCtx.js';

import {showDashboard} from './views/dashboard.js';
import {showCreate} from './views/createFurniture.js';
import {showLogin} from './views/login.js'
import {showRegister} from './views/register.js';
import {showMyFurniture} from './views/myFurniture.js';
import {showDetails} from './views/details.js';
import { showEdit } from './views/edit.js';

import {logoutUser} from './middlewares/logoutUser.js';

import {deleteRecord} from './controllers/furnitureController.js';

startApplication();


function startApplication(){
    page('/', decorateCtx, logoutUser, showDashboard);
    page('/create', decorateCtx, logoutUser, showCreate);
    page('/my-furniture', decorateCtx, logoutUser, showMyFurniture);
    page('/login', decorateCtx, logoutUser, showLogin);
    page('/register', decorateCtx, logoutUser, showRegister);
    page('/details/:id', decorateCtx, logoutUser, showDetails);
    page('/edit/:id', decorateCtx, logoutUser, showEdit);
    page('/delete/:id', decorateCtx, deleteRecord);

    page.start();
}