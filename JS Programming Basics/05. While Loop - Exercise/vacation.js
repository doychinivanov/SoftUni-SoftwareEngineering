function solve (input){
    let neededMoney = Number(input[0]);
    let money = Number(input[1]);
    let command = input[2];

    let currentMoney = Number(input[3]);
    let spendingDays =0;
    let totalDays = 0;

    for(let i =4; i<=input.length; i++){
        if(command === "spend"){
            money -= currentMoney;
                if(money<0){
                    money=0;
                }
            spendingDays++;
            totalDays++;
        } else if (command === "save"){
            money += currentMoney;
            totalDays++;
            spendingDays=0;
        }

        if(neededMoney === money){
            break;
        }

        if(spendingDays>=5){
            console.log(`You can't save the money.`);
            console.log(totalDays);
            break;
        }

        
        command = input[i];
        i++;
        currentMoney=Number(input[i]);

    }

    if(spendingDays!==5){
        console.log(`You saved the money for ${totalDays} days.`);
    }
}

solve(["250",
"150",
"spend",
"50",
"spend",
"50",
"save",
"100",
"save",
"100"])










