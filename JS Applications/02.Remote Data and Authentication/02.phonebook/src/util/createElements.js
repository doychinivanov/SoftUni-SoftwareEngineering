export function createEl(type, content, attribute, attributeValue, styleType, styleValue){
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
  };