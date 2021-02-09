function solve(input){
    let n1 = Number(input[0]);
    let theSmallestNumber = Number(input[1])

    for(let i = 2; i< input.length; i++){
        let currentNum = Number(input[i]);

        if(theSmallestNumber>currentNum){
            theSmallestNumber = currentNum;
        }
    }
    console.log(theSmallestNumber);
}

solve(["4", "45", "-20", "7", "99"]);