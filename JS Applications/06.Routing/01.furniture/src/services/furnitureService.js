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

export async function createFurniture(){
    const data = await api.post(furnitureUrl);

    return data;
}