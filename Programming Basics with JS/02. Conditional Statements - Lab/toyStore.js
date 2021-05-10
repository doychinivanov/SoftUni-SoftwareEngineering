function solve (arg1, arg2, arg3, arg4, arg5, arg6){
    let tripPrice = Number(arg1);
    let puzzleAmount = Number(arg2);
    let dollAmount = Number(arg3);
    let bearAmount = Number(arg4);
    let minionsAmount = Number(arg5);
    let truckAmount = Number(arg6);
    let totalAmount = puzzleAmount + dollAmount + bearAmount + minionsAmount + truckAmount;

    let puzzle = puzzleAmount * 2.60;
    let dolls = dollAmount * 3;
    let bear = bearAmount * 4.10;
    let minions = minionsAmount * 8.20;
    let truck = truckAmount * 2;

    let finalProfit = puzzle + dolls + bear + minions + truck;
    
    if(totalAmount>=50) {
        finalProfit = finalProfit *0.75;
    }

    finalProfit=finalProfit * 0.9;
    let diff = finalProfit - tripPrice;

    if (finalProfit >= tripPrice){
        console.log(`Yes! ${diff.toFixed(2)} lv left.`);
    } else {
        console.log(`Not enough money! ${Math.abs(diff).toFixed(2)}lv needed.`);
    }

}

solve("40.8", "20", "25", "30","50","10");
solve("320", "8", "2", "5", "5", "1")
