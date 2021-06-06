function addItem() {
    const input = document.getElementById('newItemText');
    const list = document.getElementById('items');

    if(input.value != ''){
        const newLi = document.createElement('li');
        newLi.textContent = input.value;

        list.appendChild(newLi);
        input.value = '';
    }
}