function addItem() {
    const selectMenu = document.getElementById('menu');
    const optionText = document.getElementById('newItemText');
    const optionValue = document.getElementById('newItemValue');

    const option = createEl('option', optionText.value, 'value', optionValue.value);
    selectMenu.appendChild(option);

    optionText.value = '';
    optionValue.value = '';


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