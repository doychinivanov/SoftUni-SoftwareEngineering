function solve(array){
    let bicoinPrice = 11949.16;
    let goldPrice = 67.51;
    let totalMoney = 0;
    let dailyProfit = 0;
    let bitcoins = 0;
    let day = 0;
    let firstDay = 0;

    for (let i = 0; i < array.length; i++) {
        dailyProfit = array[i] * goldPrice;
        day ++;

        if((i+1) % 3 === 0){
            dailyProfit *= 0.70;
        }

        totalMoney += dailyProfit;

        if((totalMoney - bicoinPrice) >= 0){
            if(firstDay === 0){
                firstDay = day;
            }
            while(totalMoney-bicoinPrice >= 0){
                totalMoney -= bicoinPrice;
                bitcoins++;
            }
        }
    }

    console.log(`Bought bitcoins: ${bitcoins}`);
        if(firstDay > 0){
            console.log(`Day of the first purchased bitcoin: ${firstDay}`);
        }
    console.log(`Left money: ${totalMoney.toFixed(2)} lv.`);
}

solve([3124.15, 504.212, 2511.124])