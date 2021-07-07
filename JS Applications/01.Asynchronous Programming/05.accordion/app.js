import { render } from '../node_modules/lit-html/lit-html.js';
import {getArticleTitles} from './api/api.js';
import {container} from './views/articles.js';

solution()

async function solution() {
    const main = document.getElementById('main');
    const articleTitles = await getArticleTitles();

    render(container(articleTitles), main);
}