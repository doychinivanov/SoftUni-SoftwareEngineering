export function setUserNav(){
    const guestNavigation = document.querySelector('.guest');
    const userNavigation = document.querySelector('.user');

    if(sessionStorage.getItem('userToken')){
        userNavigation.style.display = 'block';
        guestNavigation.style.display = 'none';
    } else {
        userNavigation.style.display = 'none';
        guestNavigation.style.display = 'block';
    }
}

export function unactivateButtons(){
    const navLinks = [...document.querySelectorAll('nav a')];

    navLinks.forEach(a => a.classList.remove('active'));
};

export function activeCurrentButton(button){
    if(!button) return;
    button.classList.add('active');
}

export function setUserEmail(){
    if(sessionStorage.getItem('email') !== null){
        const span = document.querySelector('.user').querySelector('span');
        span.textContent = `Welcome ${sessionStorage.getItem('email')}`
    }
}