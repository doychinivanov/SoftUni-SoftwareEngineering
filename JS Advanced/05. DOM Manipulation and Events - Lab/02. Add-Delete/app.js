function addItem() {
    const input = document.getElementById('newItemText');
    const list = document.getElementById('items');
    list.addEventListener('click', (ev)=>{
        ev.preventDefault();
        
        if(ev.target.tagName == 'A'){
            ev.target.parentNode.remove();
        }
    })

    if(input.value != ''){
        const liElement = createEl('li', input.value);
        const delLink = createEl('a', '[Delete]', 'href', '#');
        liElement.appendChild(delLink);
        list.appendChild(liElement);
        input.value = '';
    }


    function createEl(type, content, attribute, attributeValue){
        const newLi = document.createElement(type);
        newLi.textContent = content;

        if(attribute){
            newLi.setAttribute(attribute, attributeValue);
        }

        return newLi;
    }
}