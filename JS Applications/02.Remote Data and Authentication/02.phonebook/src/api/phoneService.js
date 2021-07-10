import * as api from './api.js';
import {url} from '../util/config.js';

export async function getRecord(){
    try {
        const phoneRecord = await api.get(url);

        return phoneRecord;
    } catch (err){
        alert('Something went wrong. Please try again later. Check your serve connection.');
        return;
    }
}

export async function createPhoneRecord(body){
    try {
        return await api.post(url, body);
    } catch (err){
        alert('Something went wrong. Please try again later. Check your serve connection.');
        return;
    }
}

export async function deletePhoneRecord(id){
    try {
        return await api.del(url + `/${id}`);
    } catch (err){
        alert('Something went wrong. Please try again later. Check your serve connection.');
        return;
    }
}