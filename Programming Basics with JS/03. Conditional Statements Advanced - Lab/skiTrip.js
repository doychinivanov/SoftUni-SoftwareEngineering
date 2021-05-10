function solve(arg, arg2, arg3,) {
    let days = Number(arg);
    let type = String(arg2);
    let opinion = String(arg3);
    let nights = days -1;
    let result = 0;

    switch (type){
        case "room for one person":
            result = nights * 18;
            break;
        case "apartment":
            result = nights * 25;
            if(days<10){
                result *= 0.7;
            } else if(days>10 && days<15){
                result *= 0.65;
            } else {
                result *= 0.5;
            }
            break;
        case "president apartment":
            result = nights * 35;
            if(days<10){
                result *= 0.9;
            } else if (days>=10 && days<=15){
                result *= 0.85;
            } else{
                result *= 0.8;
            }
            break;
    }

    if(opinion === "positive"){
        result *= 1.25;
    } else{
        result *= 0.9;
    }
    
    console.log(result.toFixed(2));

}

solve("30",
"president apartment",
"negative")






