function solve (arg, arg2, arg3){

    let budget = Number(arg);
    let season = String(arg2);
    let fishermen = Number(arg3);
    let price =0;

    if(season==="Spring"){
        price = 3000;
    } else if(season === "Summer" || season === "Autumn" ){
        price = 4200;
    } else if( season === "Winter"){
        price = 2600;
    }

    if(fishermen<=6){
        price *= 0.9;
    } else if(fishermen<=11){
        price *= 0.85;
    } else{
        price *= 0.75;
    }

    if(fishermen%2===0 && season != "Autumn"){
        price*=0.95;
    }

    let diff = budget-price;
    let diff1 = Math.abs(diff)

    if(price<=budget){
        console.log(`Yes! You have ${diff.toFixed(2)} leva left.`);
    } else{
        console.log(`Not enough money! You need ${diff1.toFixed(2)} leva.`);
    }

}


solve("3600",
"Autumn",
"6")

    

