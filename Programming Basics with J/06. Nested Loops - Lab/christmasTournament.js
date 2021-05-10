function solve(input){
    let index = 0;
    let days = Number(input[index]);
    let allMoney = 0;
    let totalWins = 0;
    let totalLoses = 0;

    for(let i =1; i<input.length; i++){
        let command = input[i];
        let winsPerDay = 0;
        let losesPerDay = 0;
        let moneyForTheDay = 0;

        while(command !== "Finish"){
            i++;
            let result = input[i];
            i++;
            command = input[i]

            if (result === "win"){
                moneyForTheDay += 20;
                winsPerDay++;
                totalWins +=winsPerDay;
            }else {
                moneyForTheDay += 0;
                losesPerDay++;
                totalLoses += losesPerDay;
            }
        }

        if(winsPerDay>losesPerDay){
            moneyForTheDay *= 1.10;
            allMoney += moneyForTheDay;
        } else {
            allMoney += moneyForTheDay;
        }
    }

    if(totalWins>totalLoses){
        allMoney *= 1.20;
        console.log(`You won the tournament! Total raised money: ${allMoney.toFixed(2)}`);
    } else {
        console.log(`You lost the tournament! Total raised money: ${allMoney.toFixed(2)}`);
    }
}

solve([
    "3",
    "darts",
    "lose",
    "handball",
    "lose",
    "judo",
    "win",
    "Finish",
    "snooker",
    "lose",
    "swimming",
    "lose",
    "squash",
    "lose",
    "table tennis",
    "win",
    "Finish",
    "volleyball",
    "win",
    "basketball",
    "win",
    "Finish"
])

