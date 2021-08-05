export async function createNewCar(ev, ctx) {
    ev.preventDefault();

    const formData = new FormData(ev.target);

    const brand = formData.get('brand');
    const model = formData.get('model');
    const description = formData.get('description');
    const year = Number(formData.get('year'));
    const imageUrl = formData.get('imageUrl');
    const price = Number(formData.get('price'));


    if (brand == '' || model == '' || imageUrl == '' || description == '' || year == '' || price == '') {
        alert('All fields are required!');
        return;
    }

    try {
        await ctx.storage.createCar({ brand, model, description, year, imageUrl, price});
        ctx.page.redirect('/browse');
    } catch (err) {
        alert(err.message);
    }
}

export async function editCar(ev, ctx, id) {
    ev.preventDefault();

    const formData = new FormData(ev.target);

    const brand = formData.get('brand');
    const model = formData.get('model');
    const description = formData.get('description');
    const year = Number(formData.get('year'));
    const imageUrl = formData.get('imageUrl');
    const price = Number(formData.get('price'));

    if (brand == '' || model == '' || imageUrl == '' || description == '' || year == '' || price == '') {
        alert('All fields are required!');
        return;
    }

    try {
        await ctx.storage.editCar(id, { brand, model, description, year, imageUrl, price});
        ctx.page.redirect('/details/' + id);
    } catch (err) {
        alert(err.message);
    }
}

export async function deleteCarRecord(ev, ctx, id) {
    const confirmed = confirm('Are you sure you want to delete this car?');

    if (confirmed) {
        try {
            await ctx.storage.deleteCar(id);
            ctx.page.redirect('/browse');
        } catch (err) {
            createErrorMsg(ctx, err.message);
        }
    }
}

export async function findCar(ev, ctx, state, searchTemplate){
    const year = document.getElementById('search-input').value;
    
    if (year == '') return;

    state.hasBeenSearched = true;
    try {
        const cars = await ctx.storage.searchCarByYear(year);
        state.cars = cars;
        ctx.render(searchTemplate());
    } catch (err) {
        alert(err.message);
    }
}