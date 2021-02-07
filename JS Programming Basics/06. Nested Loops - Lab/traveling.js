function solve(input){
    let index = 0;
    let command = input[index];
    index++;
    let neededBudjet = Number(input[index]);
    index++;

    while(command !== "End"){
        let destination = command;
        let money = 0;
        while(money < neededBudjet){
            command = input[index];
            money += Number(command);
            index++;
        }
        console.log(`Going to ${destination}!`);
        command = input[index];
        index++;
        neededBudjet = Number(input[index]);
        index++;
    }
}

solve(["France",
"2000",
"300",
"300",
"200",
"400",
"190",
"258",
"360",
"Portugal",
"1450",
"400",
"400",
"200",
"300",
"300",
"Egypt",
"1900",
"1000",
"280",
"300",
"500",
"End"])

