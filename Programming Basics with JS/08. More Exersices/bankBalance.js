function solve (input) {
    let total = 0;
    let i = 0;
    let addedSum = input[i];
    i++

    while(addedSum !== "NoMoreMoney"){
        let money = Number(addedSum);
        if(money < 0){
            console.log("Invalid operation");
            break;
        }
        console.log(`Increase: ${money.toFixed(2)}`);
        total+=money;
        addedSum=input[i];
        i++
    }

    console.log(`Total ${total.toFixed(2)}`);
}

solve(["5.51", 
"69.42",
"100",
"NoMoreMoney"])

