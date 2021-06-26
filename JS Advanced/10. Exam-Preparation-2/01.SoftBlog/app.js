function solve(){
   const {createArticleButton, authorInput, titleInput, categoryInput, contentInput, holderForArticles} = setDomElements();
   
   createArticleButton.addEventListener('click', createArticle);
   holderForArticles.addEventListener('click', manipulateActions);

   function createArticle(ev){
      ev.preventDefault();

      if(!inputFieldsAreEmpty(authorInput, titleInput, categoryInput, contentInput)){
         const newArticle = createArticleElement(authorInput.value, titleInput.value, categoryInput.value, contentInput.value)
         holderForArticles.appendChild(newArticle);

         resetInput(authorInput, titleInput, categoryInput, contentInput);
      };

   };

   function manipulateActions(ev){
      const article = ev.target.parentNode.parentNode;
      
      if(ev.target.classList.contains('delete')){
         deleteArticle(article);
      } else if(ev.target.classList.contains('archive')){
         archiveArticle(article);
      };
   };

   function deleteArticle(article){
      article.remove();
   };

   function archiveArticle(article){
      const title = article.querySelector('h1');
      const orderedList = document.querySelector('.archive-section ol');
      const archivedLi = createEl('li', title.textContent);

      deleteArticle(article);
      orderedList.appendChild(archivedLi);
      sortArchivedArticles(orderedList);
   };

   function sortArchivedArticles(ol){
      const sortedOl = Array.from(ol.children).sort((a,b)=> a.textContent.localeCompare(b.textContent));
      
      sortedOl.forEach(li => ol.appendChild(li));
      return ol;
   }

   function inputFieldsAreEmpty(authorInput, titleInput, categoryInput, contentInput){
      return authorInput.value == '' && titleInput.value == '' && categoryInput.value == '' && contentInput.value == '';
   }


   function resetInput(authorInput, titleInput, categoryInput, contentInput){
      authorInput.value = '';
      titleInput.value = '';
      categoryInput.value = '';
      contentInput.value = '';
   };

   function setDomElements(){
      const createArticleButton = document.getElementsByClassName('btn create')[0];
      const authorInput = document.getElementById('creator');
      const titleInput = document.getElementById('title');
      const categoryInput = document.getElementById('category');
      const contentInput = document.getElementById('content');
      const holderForArticles = document.querySelector('.site-content main section');

      return {
         createArticleButton,
         authorInput,
         titleInput,
         categoryInput,
         contentInput,
         holderForArticles
      }
   }

   function createArticleElement(author, title, category, content){
      const article = createEl('article');

      const titleH1 = createEl('h1', title);
      const categoryP = createEl('p', `Category: <strong>${category}</strong>`);
      const creatorP = createEl('p', `Creator: <strong>${author}</strong>`);
      const contentP = createEl('p', content);

      const divWithButtons = createEl('div', null, 'class', 'buttons');
      const deleteBtn = createEl('button', 'Delete', 'class', 'btn delete');
      const archiveBtn = createEl('button', 'Archive', 'class', 'btn archive');

      divWithButtons.appendChild(deleteBtn);
      divWithButtons.appendChild(archiveBtn);

      
      article.appendChild(titleH1);
      article.appendChild(categoryP);
      article.appendChild(creatorP);
      article.appendChild(contentP);
      article.appendChild(divWithButtons);

      return article;
   }

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

}
