import {getAllPosts, getCommnets, getPostById} from './api/api.js';
import {render} from './node_modules/lit-html/lit-html.js';
import {selectTemplate} from './views/optionsTemplate.js';
import {createComments} from './views/commentsTemplate.js';
import * as elements from './util/setDomElements.js';

attachEvents();

async function attachEvents() {
    const posts = await getAllPosts();

    if(posts == 'Error'){
        alert('Something went wrong. Try again later.')
        return;
    }

    elements.loadBtn.addEventListener('click', ()=> render(selectTemplate(Object.values(posts)), elements.selectArea));
    elements.viewBtn.addEventListener('click', perparePostDetails);
    
}

async function perparePostDetails(ev){
    const option = [...document.querySelectorAll('option')].filter(x => x.selected == true)[0];
    
    const [currentPost, comments] = await Promise.all([getPostById(option.value), getCommnets()]);

    if(currentPost == 'Error' || comments == 'Error'){
        alert('Something went wrong. Try again later!');
        return;
    }

    const commentsForCurrentPost = Object.values(comments).filter(c => c.postId == option.value);
    render(createComments(currentPost, commentsForCurrentPost), elements.commentsHolder);
}