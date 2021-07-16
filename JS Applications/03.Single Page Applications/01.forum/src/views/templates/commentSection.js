import { html } from 'https://unpkg.com/lit-html?module';
import { postComment } from '../home.js';

export const commentElement = (post, postComments) => html`
<div class="theme-content">

    <div class="theme-title">
        <div class="theme-name-wrapper">
            <div class="theme-name">
                <h2>${post.topic}</h2>

            </div>

        </div>
    </div>


    <div class="comment">

        ${postOwnerTemplate(post)}

        <div id="user-comment">
            ${postComments.map(commentsTemplate)}
        </div>


        <div class="answer-comment">
            <p><span>currentUser</span> comment:</p>
            <div class="answer">
                <form @submit=${postComment} data-id="${post._id}">
                    <textarea name="postText" id="comment" cols="30" rows="10"></textarea>
                    <div>
                        <label for="username">Username <span class="red">*</span></label>
                        <input type="text" name="username" id="username">
                    </div>
                    <button>Post</button>
                </form>
            </div>
        </div>
    </div>

</div>
`;

const postOwnerTemplate = (post) => html`
    <div class="header">
        <img src="./static/profile.png" alt="avatar">
        <p><span>${post.username}</span> posted on <time>${post.date}</time></p>
    
        <p class="post-content">${post.content}</p>
    </div>
`;

const commentsTemplate = (comment) => html`
<div class="topic-name-wrapper">
    <div class="topic-name">
        <p><strong>${comment.username}</strong> commented on <time>${comment.date}</time></p>
        <div class="post-content">
            <p>${comment.content}</p>
        </div>
    </div>
</div>
`;