import * as storage from '../services/carService.js';

export function storageMiddleware(ctx, next){
    ctx.storage = {...storage}

    next();
}