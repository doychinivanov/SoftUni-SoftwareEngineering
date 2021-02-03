function solve (arg, arg2, arg3) {
    let type = String(arg);
    let amount = Number(arg2);
    let budjet = Number(arg3);

    let rosesPrice =5;
    let dahliaPrice = 3.8;
    let tulipusPrice = 2.8;
    let narcissusPrice = 3;
    let gladioulusPrice = 2.5;

    let currentPrice = 0;

    switch (type){
        case "Roses":
            currentPrice += (amount * rosesPrice);
            if(amount>80){
                currentPrice *= 0.9;
            }
            break;
        case "Dahlias":
            currentPrice += (amount * dahliaPrice);
            if(amount>90){
                currentPrice *= 0.85;
            }
            break;
        case "Tulips":
            currentPrice += (amount * tulipusPrice);
            if(amount>80){
                currentPrice *= 0.85;
            }
            break;
        case "Narcissus":
            currentPrice += (amount * narcissusPrice);
            if(amount<120){
                currentPrice *= 1.15;
            }
            break;
        case "Gladiolus":
            currentPrice += (amount * gladioulusPrice);
            if(amount<80){
                currentPrice *= 1.20;
            }
            break;
    }

    let diff = budjet - currentPrice;

    if(currentPrice<=budjet){
        console.log(`Hey, you have a great garden with ${amount} ${type} and ${diff.toFixed(2)} leva left.`);
    } else{
        console.log(`Not enough money, you need ${Math.abs(diff).toFixed(2)} leva more.`);
    }

}

solve("Roses",
"55",
"250")



