import {locationInput, submitBtn, currentInput, upcomingInput, container} from './util/setDomElements.js';
import {clearInputs} from './util/clearInputs.js';
import {createTodayForecast, createUmpcoming} from './util/createElements.js';
import {getCode, getCurrent, getUpcoming} from './api/data.js';

function attachEvents() {
    submitBtn.addEventListener('click', async ()=>{
        if(locationInput.value == ''){
            return;
        };

        if(document.querySelector('.forecasts')){
            document.querySelector('.forecasts').remove();
            document.querySelector('.forecast-info').remove();
        }

        container.style.display = 'block';

        const [cityData] = await getCode(locationInput.value);
        const [currentWeather, upcomingWeather] = await Promise.all([getCurrent(cityData.code), getUpcoming(cityData.code)])
        
        if(currentWeather != 'Error' && upcomingWeather != 'Error'){
        
            currentInput.appendChild(createTodayForecast(currentWeather));
            upcomingInput.appendChild(createUmpcoming(upcomingWeather));

            clearInputs([locationInput]);
        } else {
            Array.from(document.getElementsByClassName('label'))
            .forEach(x=> x.textContent = 'Error');
        }


    });
}

attachEvents();