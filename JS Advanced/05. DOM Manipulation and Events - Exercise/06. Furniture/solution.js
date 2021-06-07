function solve() {
  const buttons = Array.from(document.querySelectorAll('#container button'));
  const textareas = Array.from(document.querySelectorAll('#container textarea'));
  const tbody = document.querySelector('tbody');

  buttons[0].addEventListener('click', ()=>{
      const inputArray = JSON.parse(textareas[0].value);

      populateTable(inputArray);
  });

  buttons[1].addEventListener('click', checkOut);

  function checkOut(){
    const cart = {
      items: [],
      totalPrice: 0,
      decFac: 0
    };

    const checkedInputs = Array.from(document.querySelectorAll('input')).filter(x => x.checked);

    checkedInputs.forEach(input=>{
      const currentRow = input.parentNode.parentNode;
      const dataInParagraphs = Array.from(currentRow.querySelectorAll('p'));

      cart.items.push(dataInParagraphs[0].textContent);
      cart.totalPrice += Number(dataInParagraphs[1].textContent);
      cart.decFac += Number(dataInParagraphs[2].textContent)
    });

    textareas[1].value = `Bought furniture: ${cart.items.join(', ')}\nTotal price: ${cart.totalPrice.toFixed(2)}\nAverage decoration factor: ${cart.decFac/cart.items.length}`
  }

  function populateTable(array){
    array.forEach(element => {
      const tableRow = createEl('tr');

      const imageTD = createEl('td');
      const imageHolder = createEl('img', '', 'src', element.img);
      imageTD.appendChild(imageHolder);

      const itemTD = createEl('td');
      const itemParagrapgh = createEl('p', element.name);
      itemTD.appendChild(itemParagrapgh);

      const priceTd = createEl('td');
      const priceParagraph = createEl('p', element.price);
      priceTd.appendChild(priceParagraph);

      const decTD = createEl('td');
      const decFacParagraph = createEl('p', element.decFactor);
      decTD.appendChild(decFacParagraph);

      const checkBoxTD = createEl('td');
      const input = createEl('input', '', 'type', 'checkbox');
      checkBoxTD.appendChild(input);

      tableRow.appendChild(imageTD);
      tableRow.appendChild(itemTD);
      tableRow.appendChild(priceTd);
      tableRow.appendChild(decTD);
      tableRow.appendChild(checkBoxTD);

      tbody.appendChild(tableRow);
    })
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