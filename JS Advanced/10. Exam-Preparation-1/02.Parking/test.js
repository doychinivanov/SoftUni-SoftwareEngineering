class Parking{
    constructor(capacity){
        this.capacity = capacity;
        this.vehicles = [];
    }

    addCar(carModel, carNumber){
        if(this.capacity === 0){
            throw new Error('Not enough parking space.')
        }
        this.capacity--;
        this.vehicles.push({carModel, carNumber, payed: false})

        return `The ${carModel}, with a registration number ${carNumber}, parked.`
    };

    removeCar(carNumber){
        let currentCar = this.vehicles.find(x => x.carNumber === carNumber);

        if(!currentCar){
            throw new Error('The car, you\'re looking for, is not found.')
        }
        
        if(currentCar.payed === false){
            throw new Error(`${carNumber} needs to pay before leaving the parking lot.`)
        } else {
            this.vehicles.splice(this.vehicles.indexOf(currentCar), 1);
            this.capacity++
            return `${carNumber} left the parking lot.`
        }
    }

    pay(carNumber){
        let currentCar = this.vehicles.find(x => x.carNumber === carNumber);

        if(!currentCar){
            throw new Error(`${carNumber} is not in the parking lot.`)
        }

        if(currentCar.payed === true){
            throw new Error(`${carNumber}'s driver has already payed his ticket.`)
        } else {
            currentCar.payed = true;

            return `${carNumber}'s driver successfully payed for his stay.`
        }
    }

    getStatistics(carNumber){
        if(carNumber){
            const currentCar = this.vehicle.find(x=> x.carNumber == carNumber);

            return currentCar.payed === true ? `${currentCar.carModel} == ${carNumber} - Has payed` : `${currentCar.carModel} == ${carNumber} - Not payed`
        } else {
            const result = [];

            result.push(`The Parking Lot has ${this.capacity} empty spots left.`)
            this.vehicles.sort((a,b)=> a.carModel.localeCompare(b.carModel)).forEach(x=>{
                result.push(x.payed===true ? `${x.carModel} == ${x.carNumber} - Has payed` : `${x.carModel} == ${x.carNumber} - Not payed`)
            })
            return result.join('\n')
        }
    }
}