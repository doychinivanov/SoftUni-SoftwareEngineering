import {getIcon} from './getIcon.js';

function createElement(type,attribute, content){
    const result = document.createElement(type);
    result.textContent = content;

    if(attribute.length > 0){
        attribute.forEach(a => result.classList.add(a))
    }

    return result;
}

export function createTodayForecast(currentWeather){
    const div = createElement('div', ['forecasts']);
    const symbolSpan = createElement('span', ['condition', 'symbol'], getIcon(currentWeather.forecast.condition))
    const spanCondition = createElement('span', ['condition']);
    const spanData = createElement('span',['forecast-data'], currentWeather.name);
    const spanTemperature = createElement('span', ['forecast-data'], `${currentWeather.forecast.low}${getIcon('Degrees')}/${currentWeather.forecast.high}${getIcon('Degrees')}`)
    const spanWeather = createElement('span', ['forecast-data'], currentWeather.forecast.condition);

    spanCondition.appendChild(spanData);
    spanCondition.appendChild(spanTemperature);
    spanCondition.appendChild(spanWeather);

    div.appendChild(symbolSpan);
    div.appendChild(spanCondition);

    return div;
}

export function createUmpcoming(upcomingWeather){
    const div = createElement('div', ['forecast-info']);

    upcomingWeather.forecast.forEach(day =>{
        const upcomingSpan = createElement('span', ['upcoming']);

        const symbolSpan = createElement('span', ['symbol'], getIcon(day.condition));
        const spanTemperature = createElement('span', ['forecast-data'], `${day.low}${getIcon('Degrees')}/${day.high}${getIcon('Degrees')}`)
        const spanWeather = createElement('span', ['forecast-data'], day.condition)

        upcomingSpan.appendChild(symbolSpan);
        upcomingSpan.appendChild(spanTemperature);
        upcomingSpan.appendChild(spanWeather);
        div.appendChild(upcomingSpan);
    })

    return div;
}