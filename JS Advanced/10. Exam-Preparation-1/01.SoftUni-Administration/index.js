function solve() {
    const moduleHolder = document.querySelector('.modules');

    moduleHolder.addEventListener('click', deleteLecture);

    document.querySelector('button').addEventListener('click', (ev)=>{
        ev.preventDefault();
        const {lectureName, lectureDate, moduleName} = setDOMElements();

        if(!inputFieldsAreEmpty(lectureName, lectureDate, moduleName)){
            const moduleTitles = Array.from(document.querySelectorAll('.modules h3'));
            const existingModule = moduleTitles.find(x => x.textContent.toUpperCase() == `${moduleName.value.toUpperCase()}-MODULE`);

            if(moduleTitles.length > 0 && existingModule){
                const newLecture = createLecture(lectureName.value, formatDate(lectureDate.value));
                const currentModuleUl = existingModule.nextElementSibling;
                currentModuleUl.appendChild(newLecture);
                sortCoursesUL(currentModuleUl);
            } else {
                const newModule = createModule(moduleName.value, lectureName.value, formatDate(lectureDate.value));
                moduleHolder.appendChild(newModule);
            }
        }

        resetInput(lectureName, lectureDate, moduleName)
    });

    function inputFieldsAreEmpty(lectureName, lectureDate, moduleName){
        return lectureName.value == '' && lectureDate.value == '' && moduleName.value == 'Select module';
    }

    function deleteLecture(ev){
        if(ev.target.tagName == 'BUTTON'){
            const ul = ev.target.parentNode.parentNode;
            
            if(ul.childNodes.length > 1){
                ev.target.parentNode.remove();
            } else {
                ul.parentNode.remove();
            }
        }
    }

    function resetInput(lectureName, lectureDate, moduleName){
        lectureName.value = '';
        lectureDate.value = '';
        moduleName.value = 'Select module';
    };

    function sortCoursesUL(ul){        
        const result = Array
        .from(ul.children)
        .sort((a,b) => a.textContent.split(' - ')[1].localeCompare(b.textContent.split(' - ')[1]) 
        || a[2].textContent.split(' - ').localeCompare(b.textContent.split(' - ')[2]));;
    
        result.forEach(x => ul.appendChild(x))
        return ul;
    };

    function createModule(moduleName, lectureName, date){
        const divModule = createEl('div', null, 'class', 'module');
        const moduleTitle = createEl('h3', `${moduleName.toUpperCase()}-MODULE`);
        const ulLectures = createEl('ul');
 
        if(lectureName && date){
            const liLecture = createLecture(lectureName, date);
            ulLectures.appendChild(liLecture);
        }
        
        divModule.appendChild(moduleTitle);
        divModule.appendChild(ulLectures);


        return divModule;
    };

    function createLecture(lectureName, date){
        const li = createEl('li', null, 'class', 'flex');
        const lectureTitle = createEl('h4', `${lectureName} - ${date}`);
        const delButton = createEl('button', 'Del', 'class', 'red');

        li.appendChild(lectureTitle);
        li.appendChild(delButton);
        
        return li;
    }

    function formatDate(date){
        let [day, time] = date.split('T');
        day = day.split('-').join('/');
        
        return `${day} - ${time}`
    }

    function setDOMElements(){
        const lectureName = document.querySelector('input[name="lecture-name"]');
        const lectureDate = document.querySelector('input[name="lecture-date"]');
        const moduleName = document.querySelector('select');

        return{
            lectureName,
            lectureDate,
            moduleName
        }
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
};