function solve(input){
    let index = 0;
    let firstNum = Number(input[index]);
    index++;
    let secondNum = Number(input[index]);
    let row = "";

    for(let i=firstNum; i <=secondNum; i++){
        let currentNum = "" + i;
        let oddSum = 0;
        let evenSum = 0;
        for(let j=0; j<currentNum.length; j++){
            let currentDigit = Number(currentNum[j]);
            if(j%2===0){
                evenSum += currentDigit;
            } else {
                oddSum += currentDigit;
            }
        }
        if(oddSum === evenSum){
            row += `${i} `;
        }
    }
    console.log(row);
}

solve(["100000",
"100050"]);