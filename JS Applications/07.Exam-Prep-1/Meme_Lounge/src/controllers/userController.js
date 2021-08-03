import { createErrorMsg } from "../util/errorParser.js";

export async function loginUser(ev, ctx){
    ev.preventDefault();
    const formData = new FormData(ev.target);

    const email = formData.get('email');
    const password = formData.get('password');

    if(email == '' || password == ''){
        createErrorMsg(ctx, 'All fields are required!');
        return;
    }

    try{
        await ctx.auth.login({email, password});
        ctx.page.redirect('/browse');
    }catch(err){
        createErrorMsg(ctx, err.message);
    }
}

export async function registerUser(ev, ctx){
    ev.preventDefault();
    const formData = new FormData(ev.target);

    const username = formData.get('username');
    const email = formData.get('email');
    const password = formData.get('password');
    const rePass = formData.get('repeatPass');
    const gender = formData.get('gender');

    if(username == '' || email == '' || password == '' || gender == null){
        createErrorMsg(ctx, 'All fields are required!');
        return;
    }

    if(password != rePass){
        createErrorMsg(ctx, 'Passwords don\'t match!');
        return;
    }

    try{
        const result = await ctx.auth.register({username, email, password, gender});
        ctx.page.redirect('/browse');
    }catch(err){
        createErrorMsg(ctx, err.message);
    }

}