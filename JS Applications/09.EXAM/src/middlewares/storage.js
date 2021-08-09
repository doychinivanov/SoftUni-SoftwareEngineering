import * as storage from '../services/bookService.js';

export function storageMiddleware(ctx, next){
    ctx.storage = {...storage}

    next();
}