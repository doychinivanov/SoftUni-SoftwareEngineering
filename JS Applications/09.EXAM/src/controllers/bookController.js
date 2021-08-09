export async function createNewBook(ev, ctx) {
    ev.preventDefault();

    const formData = new FormData(ev.target);

    const title = formData.get('title');
    const description = formData.get('description');
    const imageUrl = formData.get('imageUrl');
    const type = formData.get('type');

    if (title == '' || description == '' || imageUrl == '') {
        alert('All fields are required!');
        return;
    }

    try {
        await ctx.storage.createBook({ title, description, imageUrl, type });
        ctx.page.redirect('/');
    } catch (err) {
        alert(err.message);
    }
}

export async function editBookRecord(ev, ctx, id) {
    ev.preventDefault();

    const formData = new FormData(ev.target);

    const title = formData.get('title');
    const description = formData.get('description');
    const imageUrl = formData.get('imageUrl');
    const type = formData.get('type');

    if (title == '' || description == '' || imageUrl == '') {
        alert('All fields are required!');
        return;
    }

    try {
        await ctx.storage.editBook(id, { title, description, imageUrl, type });
        ctx.page.redirect('/details/' + id);
    } catch (err) {
        alert(err.message);
    }
}

export async function deleteBookRecord(ev, ctx, id) {
    ev.preventDefault();
    const confirmed = confirm('Are you sure you want to delete this book?');

    if (confirmed) {
        try {
            await ctx.storage.deleteBook(id);
            ctx.page.redirect('/');
        } catch (err) {
            alert(err.message);
        }
    }
}