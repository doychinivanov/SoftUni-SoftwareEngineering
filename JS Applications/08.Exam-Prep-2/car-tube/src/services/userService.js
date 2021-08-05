import * as api from '../api/api.js';
import { authUrl } from "../config/endPoints.js";

export async function login({username, password}){
    const result = await api.post(authUrl + '/login', {username, password})

    sessionStorage.setItem('userToken', result.accessToken);
    sessionStorage.setItem('userId', result._id);
    sessionStorage.setItem('username', result.username);

    return result;
}

export async function register({username, password}){
    const result = await api.post(authUrl + '/register', {username, password})

    sessionStorage.setItem('username', result.username);
    sessionStorage.setItem('userToken', result.accessToken);
    sessionStorage.setItem('userId', result._id);

    return result;
}

export async function logout(){
    await api.get(authUrl + '/logout');

    sessionStorage.removeItem('username');
    sessionStorage.removeItem('userToken');
    sessionStorage.removeItem('userId');
}