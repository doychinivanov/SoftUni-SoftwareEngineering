function solve (age, washingMachinePrice, toyPrice) {
    age = Number(age);
    washingMachinePrice = Number(washingMachinePrice);
    toyPrice = Number(toyPrice);
    let money = 10;
    let sumMoney = 0;
    let toys = 0;

    for(let i = 1; i<=age; i++){
        if(i % 2=== 0){
            sumMoney += money - 1;
            money += 10;
        } else {
            toys += 1
        }
    }

    sumMoney += toys * toyPrice;
    diff = sumMoney - washingMachinePrice;

    if(sumMoney>=washingMachinePrice){
        console.log(`Yes! ${diff.toFixed(2)}`);
    } else {
        diff = Math.abs(diff)
        console.log(`No! ${diff.toFixed(2)}`);
    }

}

solve("21", "1570.98", "3");