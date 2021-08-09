import { html, styleMap } from "../config/libraries.js";
import { deleteBookRecord } from "../controllers/bookController.js";

const detailsTemplate = (ctx, book, likes, userLike) => html`
<section id="details-page" class="details">
    <div class="book-information">
        <h3>${book.title}</h3>
        <p class="type">Type: ${book.type}</p>
        <p class="img"><img src="${book.imageUrl}"></p>
        <div class="actions">

            ${book._ownerId == sessionStorage.getItem('userId') ?
             html`<a class="button" href="/edit/${book._id}">Edit</a>
            <a @click=${(ev) => deleteBookRecord(ev, ctx, book._id)} class="button" href="javascript:void(0)">Delete</a>` 
            : ''}
            
            ${sessionStorage.getItem('userId') != book._ownerId
             ?
              html`<a @click=${(ev) => onLike(ev, ctx, book._id)} style=${styleMap({display: sessionStorage.getItem('userId') != null && userLike!=1 ? 'inline-block' : 'none'})} class="button" href="javascript:void(0)">Like</a>`
               : ''}

            <div class="likes">
                <img class="hearts" src="/images/heart.png">
                <span id="total-likes">Likes: ${likes}</span>
            </div>

        </div>
    </div>
    <div class="book-description">
        <h3>Description:</h3>
        <p>${book.description}</p>
    </div>
</section>
`;

export const showDetails = async (ctx) => {
    const book = await ctx.storage.getBookById(ctx.params.id);
    const likes = await ctx.storage.getBookLikes(book._id);
    let userLike = 0;

    if(sessionStorage.getItem('userId') != null){
        userLike = await ctx.storage.checkIfUserHasLikedBook(book._id, sessionStorage.getItem('userId'));
    }

    ctx.render(detailsTemplate(ctx, book, likes, userLike));
}

async function onLike(ev, ctx, bookId){
    try{
        await ctx.storage.likeBook({bookId});
        await showDetails(ctx);
    } catch(err){
        alert(err.message);
        return;
    }
}