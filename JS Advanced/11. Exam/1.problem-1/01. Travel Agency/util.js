function createEl(type, content, attribute, attributeValue, styleType, styleValue){
    const newLi = document.createElement(type);

    if(content){
       newLi.innerHTML = content;
    }

    if(attribute){
        newLi.setAttribute(attribute, attributeValue);
    }

    if(styleType){
       newLi.style[styleType] = styleValue; 
    }

    return newLi;
};

function resetInput(authorInput, titleInput, categoryInput, contentInput){
    authorInput.value = '';
    titleInput.value = '';
    categoryInput.value = '';
    contentInput.value = '';
};

function inputFieldsAreEmpty(authorInput, titleInput, categoryInput, contentInput){
    return authorInput.value == '' && titleInput.value == '' && categoryInput.value == '' && contentInput.value == '';
};

function sortArchivedArticles(ol){
    const sortedOl = Array.from(ol.children).sort((a,b)=> a.textContent.localeCompare(b.textContent));
    
    sortedOl.forEach(li => ol.appendChild(li));
    return ol;
};