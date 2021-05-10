function solve(arg1, arg2, arg3){
    let age = Number(arg1);
    let price = Number(arg2);
    let toyPrice = Number(arg3);
    let toyAmount = 0;
    let money = 0;
    let tempMoney = 10;

    for(let i=1; i<=age; i++){
        if(i%2 !==0){
            toyAmount++
        } else{
            money+= tempMoney -1;
            tempMoney += 10;
        }
    }

    money+= toyAmount * toyPrice;
    let diff = money - price;
    let diff2 = Math.abs(diff)
    
    if(money>=price){
        console.log(`Yes! ${diff.toFixed(2)}`);
    } else{
        console.log(`No! ${diff2.toFixed(2)}`);
    }
}

solve("21", "1570.98", "3")