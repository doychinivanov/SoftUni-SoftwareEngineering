let main;
let section;

export function setupHome(mainTarget, sectionTarget){
    main = mainTarget;
    section = sectionTarget;

    section.querySelector('.load').addEventListener('click', loadCatches);

}

export async function showHome(){
    main.innerHTML = '';
    main.appendChild(section);

    if(sessionStorage.getItem('email') == null){
        section.querySelector('.add').disabled = true;
    } else {
        section.querySelector('.add').disabled = false;
    }
}

function loadCatches(){
    console.log('hey')
}