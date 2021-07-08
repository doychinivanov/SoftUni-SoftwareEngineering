import { html } from '../node_modules/lit-html/lit-html.js';


export const createComments = (postData, comments) => html`
    <h1 id="post-title">${postData.title}</h1>
    <p id="post-body">${postData.body}</p>
    <h2>Comments</h2>
    <ul>
        ${comments.map(commentTemp)}
    </ul>
`;

const commentTemp = (comment) => html`
    <li id="${comment.id}">${comment.text}</li>
`;