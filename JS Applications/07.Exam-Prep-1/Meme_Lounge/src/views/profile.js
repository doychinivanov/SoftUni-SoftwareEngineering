import { html } from '../config/libraries.js';

const profieTemplate = (ownerMemes) => html`
    <section id="user-profile-page" class="user-profile">
        <article class="user-info">
            <img id="user-avatar-url" alt="user-profile" src="/images/${sessionStorage.getItem('gender')}.png">
            <div class="user-content">
                <p>Username: ${sessionStorage.getItem('username')}</p>
                <p>Email: ${sessionStorage.getItem('email')}</p>
                <p>My memes count: ${ownerMemes.length}</p>
            </div>
        </article>
        <h1 id="user-listings-title">User Memes</h1>
        <div class="user-meme-listings">
            
            ${ownerMemes.length > 0 ? ownerMemes.map(userMemeTemplate) : html`<p class="no-memes">No memes in database.</p>`}
        </div>
    </section>
`;

const userMemeTemplate = (meme) => html`'
<div class="user-meme">
    <p class="user-meme-title">${meme.title}</p>
    <img class="userProfileImage" alt="meme-img" src="${meme.imageUrl}">
    <a class="button" href="/details/${meme._id}">Details</a>
</div>
`

export const showProfile = async (ctx) => {
    const ownerMemes = await ctx.storage.getMemesByUserId(sessionStorage.getItem('userId'));
    console.log(ownerMemes)
    ctx.render(profieTemplate(ownerMemes));
    ctx.setUserNav();
}