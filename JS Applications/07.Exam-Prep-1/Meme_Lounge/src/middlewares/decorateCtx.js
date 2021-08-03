import {render} from '../config/libraries.js';
import { setUserNav } from '../util/userNavigation.js';
import { unactivateButtons, activeCurrentButton, setUserEmail } from '../util/userNavigation.js';
import {logout} from '../services/userService.js';

export function decorateCtx(ctx, next){
    ctx.render = (content) => render(content, document.querySelector('main'));
    ctx.error = {errorDiv: document.getElementById('errorBox'), erroSpan: document.getElementById('errorBox').querySelector('span')};

    ctx.setUserNav = setUserNav;
    setUserEmail();
    unactivateButtons();
    activeCurrentButton([...document.querySelectorAll('nav a')].find(a => a.pathname == ctx.pathname));

    document.getElementById('logoutBtn').addEventListener('click', async ()=>{ await logout(); ctx.page.redirect('/')});
    next();
}