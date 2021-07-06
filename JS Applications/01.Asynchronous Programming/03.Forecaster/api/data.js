import {CONFIG_LINKS} from '../config/index.js';
import * as api from './api.js';

async function getLocations(){
    try{
        const data = await api.get(CONFIG_LINKS.host + '/locations');
        return data;
    } catch(err){
        alert('No such city in our archives.');
        return 'Error';
    }
};

export async function getCode(cityName){
    try{
        let locations = await getLocations();
        locations = locations.filter(x=>x.name.toLowerCase() === cityName.toLowerCase());
        
        if(locations.length > 0){
            return locations;
        } else {
            return 'Error';
        }
    } catch(err){
        alert('No such city in our archives.');
        return 'Error';
    }
};

export async function getCurrent(code){
    
    try{
        const data = await api.get(CONFIG_LINKS.host + '/today/' + code);
        return data;
    } catch(err){
        alert('No such city in our archives.');
        return 'Error';
    }
};

export async function getUpcoming(code){
    
    try{
        const data = await api.get(CONFIG_LINKS.host + '/upcoming/' + code);
        return data;
    } catch(err){
        alert('No such city in our archives.');
        return 'Error';
    }
}