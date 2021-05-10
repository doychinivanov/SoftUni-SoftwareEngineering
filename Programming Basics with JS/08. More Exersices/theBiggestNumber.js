function solve (input) {
    let maxNumber = Number.MIN_SAFE_INTEGER;
    let i = 0;
    let command = input[i];
    i++;

    while( command !== "Stop"){
        let num = Number(command);
        
        if(num > maxNumber){
            maxNumber = num;
        }
        command = input[i];
        i++;
    }

    console.log(maxNumber);
}

solve(["100",
"99",
"80",
"70",
"Stop"])
