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

async function createCar(body){
    const car = await api.post(carUrl, body);

    return car;
}

async function editCar(id, body){
    const editedCar = await api.put(carUrl + `/${id}`, body);

    return editedCar;
}

async function deleteCar(id){
    const car = await api.del(carUrl + `/${id}`);

    return car;
}

async function searchCarByYear(year){
    const car = await api.get(carUrl + `?where=year%3D${year}`);

    return car;
}

export {getAllCarsSorted, getCarById, getCarsByUserId, createCar, editCar, deleteCar, searchCarByYear}