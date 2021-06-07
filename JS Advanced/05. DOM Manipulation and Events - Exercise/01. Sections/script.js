function create(words) {
   const contentHolder = document.getElementById('content');

   words.forEach(word => {
      const div = createEl('div');
      div.appendChild(createEl('p', word, '', '', 'display', 'none'));

      div.addEventListener('click', revealContent)
      contentHolder.appendChild(div);
   });

   function revealContent(ev){
      const currentParagraph = Array.from(ev.target.children)[0];
      
      currentParagraph.style.display = currentParagraph.style.display == 'none' ? 'block' : 'none';
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