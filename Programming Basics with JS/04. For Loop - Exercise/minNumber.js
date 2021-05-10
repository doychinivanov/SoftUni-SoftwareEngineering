function solve (input){
    let amount = Number(input[0]);
    let smallNumber = Number(input[1]);

    for(let i=2; i<input.length; i++){
        let currentNumber = Number(input[i]);

        if(smallNumber>=currentNumber){
            smallNumber=currentNumber;
        }
    }
    console.log(smallNumber);
}

solve(["1",
"0", "-1"])




