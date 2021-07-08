import { html } from '../node_modules/lit-html/lit-html.js';

export const selectTemplate = (posts) => html`
<select id="new-posts">
    ${posts.map(optionsTemplate)}
</select>
`;

const optionsTemplate = (post) => html`
    <option value="${post.id}">${post.title}</option>
`;