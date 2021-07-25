import {render} from '../config/libraries.js';
import { setUserNav } from '../util/userNavigation.js';
import { unactivateButtons, activeCurrentButton } from '../util/userNavigation.js';

export function decorateCtx(ctx, next){
    unactivateButtons();
    ctx.render = (content) => render(content, document.getElementById('root'));
    ctx.setUserNav = setUserNav;
    ctx.activateBtn = activeCurrentButton;

    next();
}