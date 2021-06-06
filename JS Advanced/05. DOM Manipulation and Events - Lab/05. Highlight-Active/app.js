function focused() {
    Array.from(document.querySelectorAll('input')).forEach(input=>{
        input.addEventListener('blur', onBlur);
        input.addEventListener('focus', onFocus);
    });

    function onBlur(ev){
        ev.target.parentNode.classList.remove('focused');
    };

    function onFocus(ev){
        ev.target.parentNode.classList.add('focused');
    }
}