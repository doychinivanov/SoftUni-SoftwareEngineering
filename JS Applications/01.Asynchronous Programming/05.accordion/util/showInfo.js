import { render } from '../node_modules/lit-html/lit-html.js';
import { getArticleData } from "../api/api.js";
import { contentTemplate } from "../views/articles.js";

export async function loadInfo(ev){
    const infoContainer = ev.target.parentNode.parentNode.querySelector('.extra');
    const articleInfo = await getArticleData(ev.target.id);

    toggleInfo(infoContainer, ev.target);
    render(contentTemplate(articleInfo.content), infoContainer);
}

function toggleInfo(container, button){
    container.style.display = container.style.display == 'block' ? 'none' : 'block';
    button.textContent = button.textContent == 'More' ? 'Less' : 'More';
}