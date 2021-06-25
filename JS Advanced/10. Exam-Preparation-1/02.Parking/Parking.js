class Parking{
    constructor(capacity){
        this.capacity = Number(capacity);
        this.vehicles = [];
    }

    addCar(carModel, carNumber){
        if(this.capacity == 0){
            throw new Error('Not enough parking space.');
        }

        this.capacity--;
        this.vehicles.push({carModel, carNumber, payed: false});
        return `The ${carModel}, with a registration number ${carNumber}, parked.`
    };

    removeCar(carNumber){
        const currentCar = this._findCar(carNumber);

        if(!currentCar){
            throw new Error('The car, you\'re looking for, is not found.');
        }

        if(currentCar.payed == false){
            throw new Error(`${carNumber} needs to pay before leaving the parking lot.`)
        }

        this.vehicles.splice(this.vehicles.indexOf(currentCar), 1);
        this.capacity++;
        return `${carNumber} left the parking lot.`
    }

    pay(carNumber){
        const currentCar = this._findCar(carNumber);
        
        if(!currentCar){
            throw new Error(`${carNumber} is not in the parking lot.`);
        }

        if(currentCar.payed){
            throw new Error(`${carNumber}'s driver has already payed his ticket.`)
        }

        currentCar.payed = true;
        return `${carNumber}'s driver successfully payed for his stay.`;
    
    }

    getStatistics(carNumber){
        const result = [];

        if(!carNumber){
            result.push(`The Parking Lot has ${this.capacity} empty spots left.`);
            result
            .push(this.vehicles
                .sort((a,b)=>a.carModel.localeCompare(b.carModel))
                .map(car => `${car.carModel} == ${car.carNumber} - ${car.payed ? 'Has payed' : 'Not payed'}`)
                .join('\n'));
        } else {
            const currentCar = this._findCar(carNumber);
            if(currentCar){
                result.push(`${currentCar.carModel} == ${currentCar.carNumber} - ${currentCar.payed ? 'Has payed' : 'Not payed'}`);
            }

        }

        return result.join('\n');
    }

    _findCar(carNumber){
        return this.vehicles.find(x=> x.carNumber == carNumber);
    }
}


const parking = new Parking(12);

console.log(parking.addCar("Volvo t600", "TX3691CA"));
console.log(parking.getStatistics());

console.log(parking.pay("TX3691CA"));
console.log(parking.removeCar("TX3691CA"));
console.log(parking.getStatistics());
