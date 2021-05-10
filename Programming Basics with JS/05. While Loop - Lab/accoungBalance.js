function solve(input){
    let i = 0;
    let command = Number(input[i])
    let total =0;
    let currentMoney = 0;

    while(command != "NoMoreMoney"){
        currentMoney = Number(command)
        
        if(currentMoney<=0){
            console.log(`Invalid operation!`);
            break;
        }
        console.log(`Increase: ${currentMoney.toFixed(2)}`);
        i++
        total += currentMoney;
        command= (input[i])

    }
    console.log(`Total: ${total.toFixed(2)}`);
}

solve(["120",
"45.55",
"-150"])

