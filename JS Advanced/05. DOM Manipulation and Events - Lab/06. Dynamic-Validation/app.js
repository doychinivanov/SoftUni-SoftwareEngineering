function validate() {
    document.getElementById('email').addEventListener('change', validate);

    function validate(ev){
        const regexp = /^[a-z]+@[a-z]+\.[a-z]+$/g;
        
        if(regexp.test(ev.target.value)){
            ev.target.classList.remove('error')
        } else {
            ev.target.classList.add('error')
        }
    }
}