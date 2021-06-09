function createCarObject(arr){
    const carsData = {};

    const actions = {
        create(params){
            if(params.includes('inherit')){
                const currentCar = params[0];
                const toInherit = params[2];

                if(carsData.hasOwnProperty(currentCar) == false){
                    carsData[currentCar] = {'inherits': toInherit};
                }
            } else {
                const carName = params[0];

                if(carsData.hasOwnProperty(carName) == false){
                    carsData[carName] = {};
                }
            }
        },
        set([carName, key, value]){

            if(carsData.hasOwnProperty(carName)){
                carsData[carName][key] = value;
            }
        },
        print([carName]){
            if(carsData.hasOwnProperty(carName)){
                console.log(printObject(carsData[carName]));
            }
        }
    };

    arr.forEach(element => {
        let [command, ...params] = element.split(' ');
        actions[command](params);
    });


    function printObject(obj){
        const result = [];

        inherit(obj);

        for (const key in obj) {
            result.push(`${key}:${obj[key]}`);
        }

        return result.join(', ');
    }

    function inherit(obj){
        if(obj.hasOwnProperty('inherits')){
            let firstToInherit = obj['inherits'];
            
            while(obj.hasOwnProperty('inherits')){
                Object.assign(obj, carsData[obj['inherits']]);
                let newToInherit = obj['inherits'];

                if(firstToInherit == newToInherit){
                    delete obj['inherits'];
                }

                firstToInherit = newToInherit;
            }
        }
    }
}

createCarObject(['create c1',
'create c2 inherit c1',
'create c3 inherit c2',
'set c2 model new',
'set c1 color red',
'set c1 color blue',
'print c1',
'print c3',
'print c2']
);