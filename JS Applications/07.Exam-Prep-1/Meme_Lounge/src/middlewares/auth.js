import { register, login } from "../services/userService.js";

export function authMiddleware(ctx, next){
    ctx.auth = {register, login}

    next();
}