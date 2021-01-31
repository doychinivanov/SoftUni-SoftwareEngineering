function fuelTank(fuelType, fuelLiters) {
 
    let fuel = String(fuelType);
    let fuelLit = Number(fuelLiters);
 
    if (fuelLit >= 25 && (fuel === 'Diesel' || fuel === 'Gas' || fuel === 'Gasoline')) {
        console.log(`You have enough ${fuel.toLowerCase()}.`);
    }else if (fuelLit < 25 && (fuel === 'Diesel' || fuel === 'Gas' || fuel === 'Gasoline')) {
        console.log(`Fill your tank with ${fuel.toLowerCase()}!`);
    }else {
        console.log('Invalid fuel!');
    }
      
}


fuelTank("Kerosene", "25")
