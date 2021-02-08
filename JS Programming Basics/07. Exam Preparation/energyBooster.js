function solve(arg, arg2, arg3){
    let fruit = arg;
    let size = arg2;
    let amount = Number(arg3);
    let onePrice = 0;
    let totalPrice = 0;

    if(fruit === "Watermelon"){

        if(size==="big"){
        onePrice = 5*28.70
        }else if( size==="small"){
            onePrice = 2 * 56;
        }
        
    } else if(fruit === "Mango"){

        if(size==="big"){
            onePrice = 5 * 19.60;
            }else if( size==="small"){
                onePrice = 2 * 36.66;
            }

    } else if(fruit === "Pineapple"){

        if(size==="big"){
            onePrice = 5* 24.80;
            }else if( size==="small"){
                onePrice = 2 * 42.10;
            }

    } else if(fruit === "Raspberry"){

        if(size==="big"){
            onePrice = 5* 15.20
            }else if( size==="small"){
                onePrice = 2 * 20;
            }
    }

    totalPrice = onePrice * amount;
    
    if(totalPrice >1000){
        totalPrice = totalPrice * 0.5
    } else if(totalPrice >= 400){
        totalPrice = totalPrice * 0.85;
    }

    console.log(`${totalPrice.toFixed(2)} lv.`);
}
solve("Raspberry", "small", "50")