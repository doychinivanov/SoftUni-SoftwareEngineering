import * as api from './api.js';
import {baseUrl} from '../config/index.js';

export async function getComments(){
    const comments = await api.get(baseUrl + '/comments');

    return comments;
};

export async function createComment(body){
    const comment = await api.post(baseUrl + '/comments', body);

    return comment;
}