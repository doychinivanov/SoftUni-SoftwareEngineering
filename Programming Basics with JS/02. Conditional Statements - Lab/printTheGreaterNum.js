function solve (num1, num2){
    let firstNum = Number(num1);
    let secondNum = Number(num2);

    if(firstNum>secondNum){
        console.log(firstNum);
    } else if(firstNum<secondNum){
        console.log(secondNum)
    } else if(firstNum==secondNum) {
        console.log(`${firstNum} = ${secondNum}`);
    }

}

solve("5", "3");
solve ("3", "5");
solve ("10", "10")
solve("1500", "1500")
solve("-7", "0")
solve("-15", "-15")