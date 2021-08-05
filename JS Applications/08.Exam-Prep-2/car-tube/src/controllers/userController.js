export async function loginUser(ev, ctx){
    ev.preventDefault();
    const formData = new FormData(ev.target);

    const username = formData.get('username');
    const password = formData.get('password');

    if(username == '' || password == ''){
        alert('All fields are required!');
        return;
    }

    try{
        await ctx.auth.login({username, password});
        ctx.page.redirect('/browse');
    }catch(err){
        alert(err.message);
    }
}

export async function registerUser(ev, ctx){
    ev.preventDefault();
    const formData = new FormData(ev.target);

    const username = formData.get('username');
    const password = formData.get('password');
    const rePass = formData.get('repeatPass');

    if(username == '' || password == ''){
        alert('All fields are required!');
        return;
    }

    if(password != rePass){
        alert('Passwords don\'t match!');
        return;
    }

    try{
        const result = await ctx.auth.register({username, password});
        ctx.page.redirect('/browse');
    }catch(err){
        alert(err.message);
    }

}