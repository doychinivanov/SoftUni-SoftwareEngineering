function solve() {
 
    let name = document.querySelector('input[name="task"]');
 
    let description = document.getElementById('description');
 
    let date = document.getElementById('date');
 
    let openSec = document.querySelectorAll('section')[1].children[1];
 
    let inProgressSec = document.querySelectorAll('section')[2].children[1];
 
    let completeSec = document.querySelectorAll('section')[3].children[1];
 
    document.getElementById('add').addEventListener('click', add);
 
    function moveToComplete(ev) {
        // Takes the whole article which need to be moved
        const element = ev.target.parentNode.parentNode;

        // removes the div holding the buttons
        ev.target.parentNode.remove();

        // Passes the element to the next section
        completeSec.appendChild(element);
 
    }
 
    function moveToInProgress(ev) {
        // Takes the whole article which need to be moved
        const element = ev.target.parentNode.parentNode;

        // removes the div holding the buttons
        ev.target.parentNode.remove();

        // Creates a new div with the new elements
        const divWithBtns = append(createElement('div', '', 'flex'), createElement('button', 'Delete', 'red'), createElement('button', 'Finish', 'orange'))
       
        // Appends the new div
        element.appendChild(divWithBtns);

        // removes the element from the old div
        element.remove();

        // appends it to the new div
        inProgressSec.appendChild(element);
 
    }
 
    function add(ev) {
 
        ev.preventDefault();
 
        if (name.value && description.value && date.value) {
 
            append(openSec, append(createElement('article'), createElement('h3', name.value), createElement('p', `Description: ${description.value}`), createElement('p', `Due Date: ${date.value}`), append(createElement('div', '', 'flex'), createElement('button', 'Start', 'green'), createElement('button', 'Delete', 'red'))));
        
            name.value = '';
            description.value = '';
            date.value = '';
        } 
    }
 
    function remove(ev) {
 
        console.log(ev.target);
        ev.target.parentNode.parentNode.remove();
 
    }
 
    function append(parent, ...children) {
 
        children.forEach(el => {
 
            parent.appendChild(el);
 
        });
 
        return parent;
 
    }
 
    function createElement(type, content, className) {
 
        let actions = {
 
            'Delete': remove,
 
            'Start': moveToInProgress,
 
            'Finish': moveToComplete
 
        };
 
        let element = document.createElement(type);
 
        if (content) {
 
            element.textContent = content;
 
        }
 
        if (type == 'button') {
 
            element.addEventListener('click', actions[content]);
 
        }
 
        if (className) {
 
            element.classList.add(className);
 
        }
 
        return element;
 
    }
 
}