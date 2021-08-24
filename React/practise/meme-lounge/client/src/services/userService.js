import * as api from '../api/api.js';
import { authUrl } from "../config/endPoints.js";

export async function login({email, password}){
    const result = await api.post(authUrl + '/login', null, {email, password})

    return result;
}

export async function register({username, email, password, gender}){
    const result = await api.post(authUrl + '/register', null, {username, email, password, gender})


    return result;
}

export async function logout(token){
    await api.get(authUrl + '/logout', token);
}