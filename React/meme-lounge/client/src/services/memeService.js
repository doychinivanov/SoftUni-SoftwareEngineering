import * as api from '../api/api.js';
import { memeUrl } from "../config/endPoints.js";

async function getAllMemesSorted(token){
    const memes = await api.get(memeUrl + '?sortBy=_createdOn%20desc', token);

    return memes;
}

async function getMemesByUserId(userId, token){
    const memes = await api.get(memeUrl + `?where=_ownerId%3D%22${userId}%22&sortBy=_createdOn%20desc`);

    return memes;
}

async function getOneMeme(id, token){
    const meme = await api.get(memeUrl + `/${id}`, token);

    return meme;
}

async function createMeme(body, token){
    const meme = await api.post(memeUrl, token, body);

    return meme;
}

async function editMeme(id, body, token){
    const editedMeme = await api.put(memeUrl + `/${id}`, token, body);

    return editedMeme;
}

async function deleteMeme(id, token){
    const meme = await api.del(memeUrl + `/${id}`, token);

    return meme;
}

export {getAllMemesSorted, getOneMeme, createMeme, editMeme, deleteMeme, getMemesByUserId}