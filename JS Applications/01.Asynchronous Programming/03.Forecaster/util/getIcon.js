export function getIcon(weatherType){
    const icons = {
        'Sunny' : '☀',
        'Partly sunny' : '⛅',
        'Overcast' : '☁',
        'Rain' : '☂',
        'Degrees' : '°',
    }

    return icons[weatherType];
}