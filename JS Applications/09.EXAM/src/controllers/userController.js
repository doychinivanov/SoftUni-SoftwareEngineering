export async function loginUser(ev, ctx){
    ev.preventDefault();
    const formData = new FormData(ev.target);

    const email = formData.get('email');
    const password = formData.get('password');

    if(email == '' || password == ''){
        alert('All fields are required!');
        return;
    }

    try{
        await ctx.auth.login({email, password});
        ctx.page.redirect('/');
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
    const rePass = formData.get('confirm-pass');

    if(username == '' || email == '' || password == ''){
        alert('All fields are required!');
        return;
    }

    if(password != rePass){
        alert('Passwords don\'t match!');
        return;
    }

    try{
        const result = await ctx.auth.register({email, password});
        ctx.page.redirect('/');
    }catch(err){
        alert(err.message);
    }

}