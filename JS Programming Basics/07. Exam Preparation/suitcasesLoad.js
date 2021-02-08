function solve(input){
    let index = 0;
    let capacity = Number(input[index]);
    index++;
    let command = input[index];
    let volumePerOne = 0;
    let suitcaseNumber = 0;
    let flag = true;

    while(command !== "End"){
        volumePerOne = Number(command);

        if(capacity < volumePerOne){
            flag = false;
            break;
        }
        suitcaseNumber++;
        if(suitcaseNumber%3===0){
            volumePerOne *= 1.10;
        }

        if(capacity < volumePerOne){
            flag = false;
            suitcaseNumber -=1
            break;
        } 

        capacity -= volumePerOne;
        index++;
        command = input[index];
    }

    if(flag){
        console.log(`Congratulations! All suitcases are loaded!`);
    } else {
        console.log(`No more space!`);
    }

    console.log(`Statistic: ${suitcaseNumber} suitcases loaded.`);
}

solve(["1200.2",
    "260",
    "380.5",
    "125.6",
    "305",
    "End",
    ])