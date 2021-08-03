export function createErrorMsg(ctx, message){
    ctx.error.errorDiv.style.display = 'block';
    ctx.error.erroSpan.textContent = message;

    setTimeout(()=>{ctx.error.errorDiv.style.display = 'none'}, 3000);
}