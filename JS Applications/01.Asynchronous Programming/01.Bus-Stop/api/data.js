import {CONFIG_LINKS} from '../config/index.js';
import * as api from './api.js';

export async function getBusStopData(id){
    const data = await api.get(CONFIG_LINKS.host + `/${id}`);
    return data;
}