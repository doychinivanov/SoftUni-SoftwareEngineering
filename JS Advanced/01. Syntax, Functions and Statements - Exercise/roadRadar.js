function radar(speed, terrane){
    const limits = {
        'motorway' : 130,
        'interstate' : 90,
        'city' : 50,
        'residential' : 20,
    }

    let problem = '';
    const overLimit = Math.abs(speed - limits[terrane]);

    if(overLimit <= 20) {
        problem = 'speeding';
    } else if(overLimit <= 40){
        problem = 'excessive speeding'
    } else {
        problem = 'reckless driving'
    }

    return speed <= limits[terrane] ? 
            `Driving ${speed} km/h in a ${limits[terrane]} zone` : 
            `The speed is ${overLimit} km/h faster than the allowed speed of ${limits[terrane]} - ${problem}`

}

console.log(radar(200, 'motorway'));