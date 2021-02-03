function solve (budget, season, numberOfFishermen) {
    budget = Number(budget);
    numberOfFishermen - Number(numberOfFishermen);
    let price = 0;

    switch (season) {
        case "Spring" : price = 3000; break;
        case "Autumn" : price = 4200;
        case "Summer" : price = 4200; break;
        case "Winter" : price = 2600; break;
    }

        if( numberOfFishermen <= 6){
            price *=0.9;
        } else if (numberOfFishermen >=7 && numberOfFishermen <=11){
            price *=0.85;
        } else {
            price *=0.75;
        }

        if ((numberOfFishermen % 2 === 0) && season !== "Autumn") {
            price *= 0.95;
        }


    let diff = budget - price;
    if (budget >= price) {
        console.log(`Yes! You have ${diff.toFixed(2)} leva left.`);
    } else if (budget < price) {
        console.log(`Not enough money! You need ${Math.abs(diff).toFixed(2)} leva.`);
    }
}

solve("3000", "Summer", "11");
solve("3600", "Autumn", "6");
solve("2000", "Winter", "13");