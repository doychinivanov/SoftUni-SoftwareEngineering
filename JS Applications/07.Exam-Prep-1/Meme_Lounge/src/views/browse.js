import { html } from '../config/libraries.js';

const browseTemplate = (memes) => html`
    <section id="meme-feed">
        <h1>All Memes</h1>
        <div id="memes">
            ${memes.length > 0 ? memes.map(memeTemplate) : html`<p class="no-memes">No memes in database.</p>`}
    
        </div>
    </section>
`;

const memeTemplate = (meme) => html`
    <div class="meme">
        <div class="card">
            <div class="info">
                <p class="meme-title">${meme.title}</p>
                <img class="meme-image" alt="meme-img" src="${meme.imageUrl}">
            </div>
            <div id="data-buttons">
                <a class="button" href="/details/${meme._id}">Details</a>
            </div>
        </div>
    </div>
`;

export const showAll = async (ctx) => {
    const memes = await ctx.storage.getAllMemesSorted();
    ctx.render(browseTemplate(memes));
    ctx.setUserNav();
}