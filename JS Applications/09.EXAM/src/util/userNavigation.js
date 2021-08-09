export function setUserNav(){
    const guestNavigation = document.getElementById('guest');
    const userNavigation = document.getElementById('user');

    if(sessionStorage.getItem('userToken')){
        userNavigation.style.display = 'block';
        guestNavigation.style.display = 'none';
    } else {
        userNavigation.style.display = 'none';
        guestNavigation.style.display = 'block';
    }
}

export function setUserEmail(){
    if(sessionStorage.getItem('email') !== null){
        const span = document.getElementById('user').querySelector('span');
        span.textContent = `Welcome, ${sessionStorage.getItem('email')}`;
    }
}