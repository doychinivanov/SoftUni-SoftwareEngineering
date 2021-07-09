import * as elements from './src/util/setDomElements.js';
import {getMessages, createMessage} from './src/api/chatService.js';
import {clearInputs} from './src/util/clearInputs.js';

elements.refreshBtn.addEventListener('click', async ()=>{
    const messages = await getMessages();

    const elementMessages = Object.values(messages)
    .map(msg => {
        const messageP = document.createElement('p');
        messageP.textContent = `${msg.author}: ${msg.content}`;

        return messageP;
    });

    elements.textarea.textContent = elementMessages.map(msg => msg.textContent).join('\n');
});

elements.sendBtn.addEventListener('click', async ()=>{

    if(elements.authorInput.value == '' || elements.content.value == ''){
        return alert('All fields are required!');
    }

    await createMessage({author: elements.authorInput.value, content: elements.content.value});
    clearInputs([elements.authorInput, elements.content]);
});