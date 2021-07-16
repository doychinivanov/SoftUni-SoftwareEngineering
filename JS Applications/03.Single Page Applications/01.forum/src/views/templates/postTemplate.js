import { html } from 'https://unpkg.com/lit-html?module';
import { showCurrentPost } from '../home.js';

export const postPreview = (posts) => html`
    <div>
        ${posts.map(postTemplate)}
    </div>
`;

const postTemplate = (post) => html`
<div class="topic-container">
    <div class="topic-name-wrapper">
        <div class="topic-name">
            <a @click="${showCurrentPost}" href="javascript:void(0)" class="normal">
                <h2 id="${post._id}">${post.topic}</h2>
            </a>
            <div class="columns">
                <div>
                    <p>Date: <time>${post.date}</time></p>
                    <div class="nick-name">
                        <p>Username: <span>${post.username}</span></p>
                    </div>
                </div>


            </div>
        </div>
    </div>
</div>    
`;