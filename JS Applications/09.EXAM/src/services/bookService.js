import * as api from '../api/api.js';
import { bookUrl, likeUrl } from "../config/endPoints.js";

async function getAllBooksSorted(){
    const books = await api.get(bookUrl + '?sortBy=_createdOn%20desc');

    return books;
}

async function getBookById(id){
    const book = await api.get(bookUrl + `/${id}`);

    return book;
}

async function getBooksByUserId(userId){
    const books = await api.get(bookUrl + `?where=_ownerId%3D%22${userId}%22&sortBy=_createdOn%20desc`);

    return books;
}

async function createBook(body){
    const book = await api.post(bookUrl, body);

    return book;
}

async function editBook(id, body){
    const editedBook = await api.put(bookUrl + `/${id}`, body);

    return editedBook;
}

async function deleteBook(id){
    const book = await api.del(bookUrl + `/${id}`);

    return book;
}

async function getBookLikes(id){
    const likes = await api.get(likeUrl + `?where=bookId%3D%22${id}%22&distinct=_ownerId&count`)

    return likes;
}

async function likeBook(body){
    const result = await api.post(likeUrl, body);

    return result;
}

async function checkIfUserHasLikedBook(bookId, userId){
    const result = await api.get(likeUrl + `?where=bookId%3D%22${bookId}%22%20and%20_ownerId%3D%22${userId}%22&count`);

    return result;
}

export {getAllBooksSorted, getBookById, getBookLikes, getBooksByUserId, createBook, deleteBook, editBook, likeBook, checkIfUserHasLikedBook}