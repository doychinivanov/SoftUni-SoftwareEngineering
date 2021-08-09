import * as api from '../api/api.js';
import { authUrl } from "../config/endPoints.js";

export async function login({email, password}){
    const result = await api.post(authUrl + '/login', {email, password})

    sessionStorage.setItem('email', result.email);
    sessionStorage.setItem('userToken', result.accessToken);
    sessionStorage.setItem('userId', result._id);

    return result;
}

export async function register({email, password}){
    const result = await api.post(authUrl + '/register', {email, password})

    sessionStorage.setItem('email', result.email);
    sessionStorage.setItem('userToken', result.accessToken);
    sessionStorage.setItem('userId', result._id);

    return result;
}

export async function logout(){
    await api.get(authUrl + '/logout');

    sessionStorage.removeItem('email');
    sessionStorage.removeItem('userToken');
    sessionStorage.removeItem('userId');
}