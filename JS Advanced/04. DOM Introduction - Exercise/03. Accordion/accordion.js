function toggle() {
    const moreInfo = document.getElementById('extra');
    const button = document.querySelector('.button');

    moreInfo.style.display = moreInfo.style.display == 'none' ? 'block' : 'none';
    button.textContent = moreInfo.style.display == 'none' ? 'More' : 'Less';
}