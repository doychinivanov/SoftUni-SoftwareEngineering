import * as api from './api.js';
import {url} from '../util/config.js';

export async function getBooks(){
    try {
        const books = await api.get(url);

        return books;
    } catch (err){
        alert('Something went wrong. Please try again later.');
        return;
    }
}

export async function createBook(body){
    try {
        const book = await api.post(url, body);

        return book;
    } catch (err){
        alert('Something went wrong. Please try again later.');
        return;
    }
};

export async function editBook(id, body){
    try {
        const book = await api.put(url + `/${id}`, body);

        return book;
    } catch (err){
        alert('Something went wrong. Please try again later.');
        return;
    }
}

export async function deleteBook(id){
    try {
        const book = await api.del(url + `/${id}`);

        return book;
    } catch (err){
        alert('Something went wrong. Please try again later.');
        return;
    }
}