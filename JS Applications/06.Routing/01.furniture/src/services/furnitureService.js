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