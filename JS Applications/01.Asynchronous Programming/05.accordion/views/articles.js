import { html } from '../node_modules/lit-html/lit-html.js';
import { loadInfo } from '../util/showInfo.js';

export const container = (articles) => html`
    <div>
        ${articles.map(articleTemplate)}
    </div>
`;

const articleTemplate = (article) => html`
    <div class="accordion">
        <div class="head">
            <span>${article.title}</span>
            <button @click="${(ev) => loadInfo(ev)}" class="button" id="${article._id}">More</button>
        </div>
        <div class="extra">
    
        </div>
    </div>
`;

export const contentTemplate = (content) => html`
    <p>${content}</p>
`;