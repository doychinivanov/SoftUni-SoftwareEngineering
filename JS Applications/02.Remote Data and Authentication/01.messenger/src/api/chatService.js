import * as api from './api.js';
import {url} from '../util/config.js';

export async function getMessages(){
    try {
        const messages = await api.get(url);

        return messages;
    } catch (err){
        alert('Something went wrong. Please try again later. Check your serve connection.');
        return;
    }
}

export async function createMessage(body){
    try {
        const messages = await api.post(url, body);

        return messages;
    } catch (err){
        alert('Something went wrong. Please try again later. Check your serve connection.');
        return;
    }
}