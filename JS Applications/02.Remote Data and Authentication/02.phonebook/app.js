import * as elements from './src/util/setDomElements.js';
import {getRecord, createPhoneRecord, deletePhoneRecord} from './src/api/phoneService.js';
import {createEl} from './src/util/createElements.js';
import {clearInputs} from './src/util/clearInputs.js';

elements.loadBtn.addEventListener('click', loadData);
elements.creaeBtn.addEventListener('click', createRecord)
elements.tbody.addEventListener('click', deleteRecord);

async function loadData(){
    const phoneRecord = await getRecord();

    while(elements.tbody.lastElementChild){
        elements.tbody.removeChild(elements.tbody.lastElementChild);
    }

    Object.values(phoneRecord).map(record => {
        const tr = createEl('tr');

        const tdName = createEl('td', record.person);
        const tdPhone = createEl('td', record.phone);
        const tdBtn = createEl('td');
        const btn = createEl('button', 'Delete', 'data-id', record._id);

        tdBtn.appendChild(btn);

        tr.appendChild(tdName);
        tr.appendChild(tdPhone);
        tr.appendChild(tdBtn);

        return tr;
    }).forEach(td => elements.tbody.appendChild(td));
}

async function createRecord(){
    if(elements.personInput.value == '' || elements.phoneInput.value == ''){
        alert('All fields are required!');
        return;
    }

    await createPhoneRecord({'person': elements.personInput.value, 'phone': elements.phoneInput.value});

    clearInputs([elements.personInput, elements.phoneInput]);
    loadData();
}

async function deleteRecord(ev){
    if(ev.target.tagName == 'BUTTON'){
        const dataId= ev.target.getAttribute('data-id');

        await deletePhoneRecord(dataId);

        loadData();
    }
}