export function setUserNav(){
    const guestNavigation = document.getElementById('guest');
    const userNavigation = document.getElementById('profile');

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

export function setUserGreating(){
    if(sessionStorage.getItem('username') !== null){
        const welcomeMsg = document.getElementById('welcome-msg');
        welcomeMsg.textContent = `Welcome ${sessionStorage.getItem('username')}`
    }
}