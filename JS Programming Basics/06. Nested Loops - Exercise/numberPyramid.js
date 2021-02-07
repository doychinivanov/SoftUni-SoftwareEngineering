function solve(input){
    let index = 0;
    let n = Number(input[index])
    let current = 1;
    let isBigger = false;
    let printCurrentLine = "";

    for(let rows = 1; rows<=n; rows++){
        for(let column = 1; column<=rows; column++){
            if(current > n){
                isBigger = true;
                break;
            }
            printCurrentLine +=current + " ";
            current++;
        }
        console.log(printCurrentLine);
        printCurrentLine = "";
        if(isBigger){
            break;
        }
    }
}

solve(["15"]);