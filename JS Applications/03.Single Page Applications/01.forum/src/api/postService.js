import * as api from './api.js';
import {baseUrl} from '../config/index.js';

export async function getPosts(){
    const posts = await api.get(baseUrl + '/posts');

    return posts;
};

export async function getPostById(id){
    const post = await api.get(baseUrl + '/posts/' + id);

    return post;
}

export async function createPost(body){
    const post = await api.post(baseUrl + '/posts', body);

    return post;
}