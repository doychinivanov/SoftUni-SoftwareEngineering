function constructCar(requirements){
    const engines = [
        { power: 90, volume: 1800 },
        { power: 120, volume: 2400 },
        { power: 200, volume: 3500 }
    ];

    const car = {
        model: requirements.model,
        engine: getEngine(requirements.power),
        carriage: getCarriage(requirements.carriage, requirements.color),
        wheels: getWheels(requirements.wheelsize)
    };

    return car;


    function getEngine(power){
        for (const currentEngine of engines) {
            if(currentEngine.power >= power){
                return currentEngine;
            }
        }
    }

    function getCarriage(type, color){
        return {
            type,
            color
        }
    }

    function getWheels(size){
        size = Math.floor(size);
        size % 2 == 0 ? size-- : size;
        return Array(4).fill(size);
    }
}

console.log(constructCar(
    {
        model: 'VW Golf II',
        power: 90,
        color: 'blue',
        carriage: 'hatchback',
        wheelsize: 14
    }
));