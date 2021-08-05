import {render} from '../config/libraries.js';
import { setUserNav } from '../util/userNavigation.js';
import { unactivateButtons, activeCurrentButton, setUserGreating } from '../util/userNavigation.js';
import {logout} from '../services/userService.js';

export function decorateCtx(ctx, next){
    ctx.render = (content) => render(content, document.getElementById('site-content'));

    ctx.setUserNav = setUserNav;
    setUserGreating();
    unactivateButtons();
    activeCurrentButton([...document.querySelectorAll('nav a')].find(a => a.pathname == ctx.pathname));

    document.getElementById('logoutBtn').addEventListener('click', async ()=>{ await logout(); ctx.page.redirect('/')});
    next();
}