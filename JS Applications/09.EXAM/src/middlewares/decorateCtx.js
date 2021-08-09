import {render} from '../config/libraries.js';
import { setUserNav } from '../util/userNavigation.js';
import { setUserEmail } from '../util/userNavigation.js';

export function decorateCtx(ctx, next){
    ctx.render = (content) => render(content, document.querySelector('main'));

    setUserNav();
    setUserEmail();
    // unactivateButtons();
    // activeCurrentButton([...document.querySelectorAll('nav a')].find(a => a.pathname == ctx.pathname));

    next();
}