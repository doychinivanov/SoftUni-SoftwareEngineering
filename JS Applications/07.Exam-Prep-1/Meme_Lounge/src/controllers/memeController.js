import { createErrorMsg } from "../util/errorParser.js";

export async function createNewMeme(ev, ctx) {
    ev.preventDefault();

    const formData = new FormData(ev.target);

    const title = formData.get('title');
    const description = formData.get('description');
    const imageUrl = formData.get('imageUrl');

    if (title == '' || description == '' || imageUrl == '') {
        createErrorMsg(ctx, 'All fields are required!');
        return;
    }

    try {
        await ctx.storage.createMeme({ title, description, imageUrl });
        ctx.page.redirect('/browse');
    } catch (err) {
        createErrorMsg(ctx, err.message);
    }
}

export async function editMeme(ev, ctx, id) {
    ev.preventDefault();

    const formData = new FormData(ev.target);

    const title = formData.get('title');
    const description = formData.get('description');
    const imageUrl = formData.get('imageUrl');

    if (title == '' || description == '' || imageUrl == '') {
        createErrorMsg(ctx, 'All fields are required!');
        return;
    }

    try {
        await ctx.storage.editMeme(id, { title, description, imageUrl });
        ctx.page.redirect('/details/' + id);
    } catch (err) {
        createErrorMsg(ctx, err.message);
    }
}

export async function deleteMemeRecord(ev, ctx, id) {
    const confirmed = confirm('Are you sure you want to delete this meme?');

    if (confirmed) {
        try {
            await ctx.storage.deleteMeme(id);
            ctx.page.redirect('/browse');
        } catch (err) {
            createErrorMsg(ctx, err.message);
        }
    }
}