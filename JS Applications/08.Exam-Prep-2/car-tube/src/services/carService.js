import * as api from '../api/api.js';
import { carUrl } from "../config/endPoints.js";

async function getAllCarsSorted(){
    const cars = await api.get(carUrl + '?sortBy=_createdOn%20desc');

    return cars;
}

async function getCarById(id){
    const car = await api.get(carUrl + `/${id}`);

    return car;
}

async function getCarsByUserId(userId){
    const cars = await api.get(carUrl + `?where=_ownerId%3D%22${userId}%22&sortBy=_createdOn%20desc`);

    return cars;
}

export {getAllCarsSorted, getCarById, getCarsByUserId}