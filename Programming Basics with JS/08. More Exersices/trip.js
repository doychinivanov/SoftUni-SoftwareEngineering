function solve(budget, season) {
    budget = Number(budget);
    let destination = 0;
    let price = 0;
    let place = 0;

   if (budget <= 100) {
    destination = "Bulgaria";
        if (season == "summer") {
            price = budget * 0.30;
            place = "Camp"
            console.log(`Somewhere in ${destination}`);
            console.log(`${place} - ${price.toFixed(2)}`);
        } else if (season == "winter"){
            price = budget * 0.70;
            place = "Hotel";
            console.log(`Somewhere in ${destination}`);
            console.log(`${place} - ${price.toFixed(2)}`);
        }
   } else if (budget >100 && budget <= 1000) {
    destination = "Balkans";
        if (season == "summer"){
            price = budget * 0.40;
            place = "Camp"
            console.log(`Somewhere in ${destination}`);
            console.log(`${place} - ${price.toFixed(2)}`);
        } else if (season =="winter"){
            price = budget * 0.80;
            place = "Hotel";
            console.log(`Somewhere in ${destination}`);
            console.log(`${place} - ${price.toFixed(2)}`);
        }
   } else if (budget > 1000){
    destination = "Europe";
    price = budget * 0.90;
    place = "Hotel";
    console.log(`Somewhere in ${destination}`);
    console.log(`${place} - ${price.toFixed(2)}`);
   }

}

solve("50", "summer");
solve("75", "winter");
solve("312", "summer");
solve("678.53","winter");
solve("1500", "summer");