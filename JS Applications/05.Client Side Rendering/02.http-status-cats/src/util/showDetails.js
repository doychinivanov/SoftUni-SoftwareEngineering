export function showDetails(ev){
    if(ev.target.classList.contains('showBtn')){
        const details = ev.target.nextElementSibling;

        details.style.display = details.style.display == 'none' ? 'block' : 'none';
        ev.target.textContent = details.style.display == 'block' ? 'Hide status code' : 'Show status code';
    }
}