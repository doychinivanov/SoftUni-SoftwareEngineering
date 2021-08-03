import * as storage from '../services/memeService.js';

export function storageMiddleware(ctx, next){
    ctx.storage = {...storage}

    next();
}