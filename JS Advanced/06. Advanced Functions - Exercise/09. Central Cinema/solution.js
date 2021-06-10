function solve() {
    document.querySelector('form button').addEventListener('click', putMovieOnScreen);
    const inputs = Array.from(document.querySelectorAll('form input'))
    const screenMoviesUl = document.querySelector('#movies ul');
    screenMoviesUl.addEventListener('click', archiveMovie);
    document.querySelector('#archive button').addEventListener('click', (ev)=>{
        const liToRemove = Array.from(ev.target.parentNode.querySelectorAll('li'));
        liToRemove.forEach(li => li.remove());
    })

    const archivedMoviesUl = document.querySelector('#archive ul');
    archivedMoviesUl.addEventListener('click', deleteMovie);

    function putMovieOnScreen(ev){
        ev.preventDefault();
        const name = inputs[0].value;
        const hall = inputs[1].value;
        const price = inputs[2].value;

        if(name != '' && hall != '' && price != '' && isNaN(Number(price))==false){
            const newMovieLi = createOnScreenMovie(name, hall, price);
            screenMoviesUl.appendChild(newMovieLi);
            inputs.forEach(input=>input.value = '');
        }
        
    }

    function archiveMovie(ev){
        if(ev.target.tagName == 'BUTTON'){
            const currentLi = ev.target.parentNode.parentNode;
            const movieName = currentLi.querySelector('span');
            const ticketPrice = currentLi.querySelector('div strong');
            const soldTickets = currentLi.querySelector('input');

            if(isNaN(Number(soldTickets.value)) == false && soldTickets.value != '' && Number(soldTickets.value)>=0){
                const archivedLi = createArchiveMovie(movieName.textContent, ticketPrice.textContent, soldTickets.value);
                archivedMoviesUl.appendChild(archivedLi);
                currentLi.remove();
            }
        }
    }

    function deleteMovie(ev){
        ev.target.parentNode.remove();
    }

    function createOnScreenMovie(name, hall, price){
        const liElement = createEl('li');

        const span = createEl('span', name);
        const strongHall = createEl('strong', `Hall: ${hall}`);

        const divElement = createEl('div');
        const strongPrice = createEl('strong', Number(price).toFixed(2));
        const input = createEl('input', '', 'placeholder', 'Tickets Sold');
        const button = createEl('button', 'Archive');

        divElement.appendChild(strongPrice);
        divElement.appendChild(input);
        divElement.appendChild(button);

        liElement.appendChild(span);
        liElement.appendChild(strongHall);
        liElement.appendChild(divElement);

        return liElement;
    }


    function createArchiveMovie(name, price, soldTickets){
        const liElement = createEl('li');
        const spanName = createEl('span', name);
        const strongPrice = createEl('strong', `Total amount: ${(Number(price) * Number(soldTickets)).toFixed(2)}`);
        const button = createEl('button', 'Delete');

        liElement.appendChild(spanName);
        liElement.appendChild(strongPrice);
        liElement.appendChild(button);

        return liElement;
    }


    function createEl(type, content, attribute, attributeValue, styleType, styleValue){
        const newLi = document.createElement(type);
  
        if(content){
           newLi.textContent = content;
        }
  
        if(attribute){
            newLi.setAttribute(attribute, attributeValue);
        }
  
        if(styleType){
           newLi.style[styleType] = styleValue; 
        }
  
        return newLi;
    }
}