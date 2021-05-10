function solve(arg, arg2){
    let budget = Number(arg);
    let season = String(arg2);
    let destination = "";
    let price = 0;
    let type = "";


    if(budget<=100){
        destination = "Bulgaria";

        if(season === "summer"){
            price = budget * 0.3;
            type = "Camp";
        } else if(season === "winter"){
            price = budget * 0.7;
            type = "Hotel";
        }
    } else if(budget <=1000){
        destination = "Balkans";

        if(season === "summer"){
            price = budget * 0.4;
            type = "Camp";
        } else if(season === "winter"){
            price = budget * 0.8;
            type = "Hotel";
        }
    } else if(budget>1000){
        destination = "Europe";
        price = budget * 0.9;
        type = "Hotel";

    }


    console.log(`Somewhere in ${destination}`);
    console.log(`${type}- ${price.toFixed(2)}`);
}

solve ("50", "summer")