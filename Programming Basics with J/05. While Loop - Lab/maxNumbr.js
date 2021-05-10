function solve(input){
    let i = 0;
    let command = input[i];
    let currentNumber = Number.MIN_SAFE_INTEGER;

    while(command !== "Stop"){
        if(command <= currentNumber){
            command = currentNumber;
        }
        currentNumber = Number(command);
        i++;
        command= input[i]
    }

    console.log(currentNumber);
}

solve(["-1",
"-2",
"Stop"])




