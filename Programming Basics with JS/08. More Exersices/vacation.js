function solve (input) {
    let i = 0;
    let neededMoney = Number(input[i]);
    i++
    let myMoney = Number(input[i]);
    i++;
    let command = input[i];
    i++;
    let currentMoney = Number(input[i]);

    let spentDays = 0;


    while (myMoney < neededMoney) {
        spentDays++
        if(command =="spend"){
            if(myMoney < currentMoney){
                myMoney = 0;
            }else{
                myMoney -= currentMoney;
            }
        } else {
            myMoney += currentMoney;
        }

        if(spentDays >= 5){
            console.log(`You can't save the money.`);
            console.log(`${spentDays}`);
            break;
        }
        i++;
        command = input[i];
        i++;
        currentMoney = Number(input[i]);

    }
    if( myMoney >= neededMoney) {
        console.log(`You saved the money for ${spentDays} days.`);
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

