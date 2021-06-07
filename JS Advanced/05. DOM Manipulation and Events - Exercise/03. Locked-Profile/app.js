function lockedProfile() {
    document.querySelector('#main').addEventListener('click', toggleInfo);

    function toggleInfo(ev){
        if(ev.target.tagName == 'BUTTON'){
            const lockedCheckbox = ev.target.parentNode.querySelector('input[type=radio]:checked');

            if(lockedCheckbox.value == 'unlock'){
                ev.target.previousElementSibling.style.display = ev.target.previousElementSibling.style.display === 'block' ? 'none' : 'block';
                ev.target.textContent = ev.target.previousElementSibling.style.display === 'none' ? 'Show more' : 'Hide it';
            }
        }
    }
}