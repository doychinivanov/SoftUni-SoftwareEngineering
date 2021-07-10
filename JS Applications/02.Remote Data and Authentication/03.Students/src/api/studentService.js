import * as api from './api.js';
import {url} from '../util/config.js';

export async function getStudents(){
    try {
        const students = await api.get(url);

        return students;
    } catch (err){
        throw err;
    }
}

export async function createStudent(body){
    try {
        const student = await api.post(url, body);

        return student;
    } catch (err){
        throw err;
    }
}