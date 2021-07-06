import { getBusStopData } from '../api/data.js';

async function getBusData(id) {
    try {
        const result = await getBusStopData(id);
        return result;
    } catch(err){
        return 'Error'
    }
}

export { getBusData };