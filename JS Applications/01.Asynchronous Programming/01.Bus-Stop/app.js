import {idInput, submitBtn, busNameInput, busesUl} from './util/setDomElements.js';
import {clearInputs} from './util/clearInputs.js';
import {getBusData} from './services/busService.js';
import {render} from './util/renderDom.js';

start();

function start() {
    submitBtn.addEventListener('click', async () =>{
        if(idInput.value != ''){
            const response = await getBusData(idInput.value);

            if(response != 'Error'){
                render({busNameInput, busesUl}, response.name, response.buses);
                clearInputs([idInput])
            } else {
                render({busNameInput, busesUl}, response);
            };
        };
    });
}