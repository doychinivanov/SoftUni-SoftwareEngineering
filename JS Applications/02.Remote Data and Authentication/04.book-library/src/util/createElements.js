export function createRows(book) {
   const firstRow = createEl('td', book.title);
   const secondRow = createEl('td', book.author);
   const thirdRow = document.createElement('td');
   const editBtn = createEl('button', 'Edit', 'id', 'edit');
   const deleteBtn = createEl('button', 'Delete', 'id', 'delete');

   thirdRow.appendChild(editBtn);
   thirdRow.appendChild(deleteBtn);

   const tableRow = document.createElement('tr');
   tableRow.setAttribute('id', book._id);
   tableRow.appendChild(firstRow);
   tableRow.appendChild(secondRow);
   tableRow.appendChild(thirdRow);

   return tableRow;
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
  };