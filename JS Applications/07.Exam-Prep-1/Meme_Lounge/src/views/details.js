import { html } from '../config/libraries.js';
import { deleteMemeRecord } from '../controllers/memeController.js';

const detailsTemplate = (ctx, meme) => html`
    <section id="meme-details">
        <h1>Meme Title: ${meme.title}
    
        </h1>
        <div class="meme-details">
            <div class="meme-img">
                <img alt="meme-alt" src="${meme.imageUrl}">
            </div>
            <div class="meme-description">
                <h2>Meme Description</h2>
                <p>
                    ${meme.description}
                </p>
    
                ${sessionStorage.getItem('userId') == meme._ownerId ? html`<a class="button warning" href="/edit/${meme._id}">Edit</a>
                <button @click=${(ev) => deleteMemeRecord(ev, ctx, meme._id)} class="button danger">Delete</button>` : ''}
    
            </div>
        </div>
    </section>
`;

export const showDetails = async (ctx) => {
    const meme = await ctx.storage.getOneMeme(ctx.params.id);
    ctx.render(detailsTemplate(ctx, meme));
    ctx.setUserNav();
}