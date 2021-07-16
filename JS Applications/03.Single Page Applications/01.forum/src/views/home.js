import { getPosts, getPostById, createPost } from "../api/postService.js";
import { render } from 'https://unpkg.com/lit-html?module';
import {postHolder} from '../util/setDomElements.js';
import {postPreview} from './templates/postTemplate.js';
import {commentElement} from './templates/commentSection.js';
import {createComment, getComments} from '../api/commentService.js';

let main;
let section;

export function setupHome(mainTarget, sectionTarget) {
    main = mainTarget;
    section = sectionTarget;
}

export async function showHome() {
    main.innerHTML = '';
    main.appendChild(section);
    loadPosts();

    section.addEventListener('submit', createPostRecord);

    section.querySelector('.cancel').addEventListener('click', (ev)=>{
        ev.preventDefault();
        const form = document.querySelector('#postForm');
        form.reset();
    });
}

async function createPostRecord(ev){
    ev.preventDefault();
    const form = ev.target;

    const formData = new FormData(form);

    const topicName = formData.get('topicName');
    const username = formData.get('username');
    const postText = formData.get('postText');

    if(topicName == '' || username == '' || postText == ''){
        alert('All fields are required.');
        return;
    }

    try{
        await createPost({topic: topicName, username, content: postText, date: new Date()}) 
        form.reset();
        alert('Successfully created!');
        showHome();
    } catch(err){
        alert(err.message);
        return;
    }
}

async function loadPosts(){
    let posts;
    try{
        posts = await getPosts();
    } catch(err){
        alert(err.message);
        return;
    }

    if(Object.values(posts).length > 0){
        render(postPreview(Object.values(posts)), postHolder)
    }
}

export async function showCurrentPost(ev, id){
    const postId = id ? id : ev.target.id;
    let currentPost;
    let currentComments;

    try{
        currentPost = await getPostById(postId);
        currentComments = await getComments();
        currentComments = Object.values(currentComments).filter(x => x.postId == postId);
    } catch(err){
        alert(err.message);
        return;
    }

    render(commentElement(currentPost, currentComments), main);
}

export async function postComment(ev){
    ev.preventDefault();
    const form = ev.target;
    const postId = form.getAttribute('data-id');

    const formData = new FormData(form);

    const commentContent = formData.get('postText');
    const username = formData.get('username');

    if(commentContent == '' || username == ''){
        alert('All fields are required!');
        return;
    }

    try{
        await createComment({username, content: commentContent, postId, date: new Date()})
    } catch(err){
        alert(err.message);
        return;
    }

    showCurrentPost(null, postId);
    form.reset();
}