import {render} from '../config/libraries.js';
import { setUserNav } from '../util/userNavigation.js';

export function decorateCtx(ctx, next){
    ctx.render = (content) => render(content, document.getElementById('root'));
    ctx.setUserNav = setUserNav;

    next();
}