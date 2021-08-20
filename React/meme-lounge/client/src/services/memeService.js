import * as api from '../api/api.js';
import { memeUrl } from "../config/endPoints.js";

async function getAllMemesSorted(){
    const memes = await api.get(memeUrl + '?sortBy=_createdOn%20desc');

    return memes;
}

async function getMemesByUserId(userId){
    const memes = await api.get(memeUrl + `?where=_ownerId%3D%22${userId}%22&sortBy=_createdOn%20desc`);

    return memes;
}

async function getOneMeme(id){
    const meme = await api.get(memeUrl + `/${id}`);

    return meme;
}

async function createMeme(body){
    const meme = await api.post(memeUrl, body);

    return meme;
}

async function editMeme(id, body){
    const editedMeme = await api.put(memeUrl + `/${id}`, body);

    return editedMeme;
}

async function deleteMeme(id){
    const meme = await api.del(memeUrl + `/${id}`);

    return meme;
}

export {getAllMemesSorted, getOneMeme, createMeme, editMeme, deleteMeme, getMemesByUserId}