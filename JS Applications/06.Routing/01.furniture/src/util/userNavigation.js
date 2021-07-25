export function setUserNav(){
    const guestNavigation = document.getElementById('guest');
    const userNavigation = document.getElementById('user');

    if(sessionStorage.getItem('userToken')){
        userNavigation.style.display = 'inline-block';
        guestNavigation.style.display = 'none';
    } else {
        userNavigation.style.display = 'none';
        guestNavigation.style.display = 'inline-block';
    }
}