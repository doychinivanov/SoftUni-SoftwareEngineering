function solve (arg, arg2) {
    let degrees = Number(arg);
    let time = arg2;
    let outfit = "";
    let shoes = "";


    if(degrees >= 10 && degrees<= 18){
        if(time === "Morning"){
            outfit = "Sweatshirt";
            shoes = "Sneakers";
        } else if (time === "Afternoon" || time=== "Evening"){
            outfit = "Shirt";
            shoes = "Moccasins";
        }
    } else if(degrees>18 && degrees<=24){
        if(time === "Morning"){
            outfit = "Shirt";
            shoes = "Moccasins";
        } else if(time==="Afternoon"){
            outfit = "T-Shirt";
            shoes = "Sandals";
        } else if (time === "Evening"){
            outfit = "Shirt";
            shoes = "Moccasins";
        }
    } else if(degrees>=25){
        if(time === "Morning"){
            outfit = "T-Shirt";
            shoes = "Sandals";
        } else if(time==="Afternoon"){
            outfit = "Swim Suit";
            shoes = "Barefoot";
        } else if (time === "Evening"){
            outfit = "Shirt";
            shoes = "Moccasins";
        }
    }



    console.log(`It's ${degrees} degrees, get your ${outfit} and ${shoes}.`);

}

solve("16",
"Morning")

