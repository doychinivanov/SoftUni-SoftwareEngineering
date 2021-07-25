import {logout} from '../services/userService.js';

export function logoutUser(ctx, next){
    const logoutBtn = document.getElementById('logoutBtn');

    if(logoutBtn){
        logoutBtn.addEventListener('click', async ()=>{
            try{
                await logout();
            } catch(err){
                alert(err.message);
                return;
            }

            ctx.setUserNav();
            ctx.page.redirect('/');
        });
    };

    next();
} 