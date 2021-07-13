import { dataUrl } from "../util/config.js";
import * as api from './api.js';

export async function getCatches(){
    const data = await api.get(dataUrl);

    return data;
}

export async function createCatchRecord(data){
    const response = await api.post(dataUrl, data);

    return response;
}