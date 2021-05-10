function solve (fuel, expences, totalLaps) {
    fuel = Number(fuel);
    expences = Number(expences);
    totalLaps = Number(totalLaps);

    for(let lap = 0; lap < totalLaps; lap++){
        fuel -= expences - 0.1;

        if(fuel<=0){
            console.log(`You are out of fuel in ${lap} round.`);
            break;
        } 
    }
    if(fuel>0){
        console.log(`Congrats! You won the race!`);
    }
}

solve("70", "6.5", "10");
