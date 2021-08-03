import { html } from '../config/libraries.js';
import { createNewMeme } from '../controllers/memeController.js';

const createTemplate = (ctx) => html`
    <section id="create-meme">
        <form @submit=${(ev) => createNewMeme(ev, ctx)} id="create-form">
            <div class="container">
                <h1>Create Meme</h1>
                <label for="title">Title</label>
                <input id="title" type="text" placeholder="Enter Title" name="title">
                <label for="description">Description</label>
                <textarea id="description" placeholder="Enter Description" name="description"></textarea>
                <label for="imageUrl">Meme Image</label>
                <input id="imageUrl" type="text" placeholder="Enter meme ImageUrl" name="imageUrl">
                <input type="submit" class="registerbtn button" value="Create Meme">
            </div>
        </form>
    </section>
`;

export const showCreate = (ctx) => {
    ctx.render(createTemplate(ctx));
    ctx.setUserNav();
}