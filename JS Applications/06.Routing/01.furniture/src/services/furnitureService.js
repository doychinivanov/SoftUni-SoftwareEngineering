import * as api from '../api/api.js';
import { furnitureUrl } from '../config/endPoints.js';

export async function getAllFurniture(){
    const data = await api.get(furnitureUrl);

    return data;
}

export async function getFurnitureById(id){
    const data = await api.get(furnitureUrl + `/${id}`);

    return data;
}

export async function getFurnitureByUserId(userId){
    const data = await api.get(furnitureUrl + `?where=_ownerId%3D%22${userId}%22`)

    return data;
}

export async function createFurniture(body){
    const data = await api.post(furnitureUrl, body);

    return data;
}

export async function editFurniture(id, body){
    const data = await api.put(furnitureUrl + `/${id}`, body);

    return data;
}

export async function deleteFurniture(id){
    const data = await api.del(furnitureUrl  + `/${id}`);

    return data;
}