function solve(input){
    let index = 0;
    let numOne = Number(input[index]);
    index++;
    let numTwo = Number(input[index]);
    index++;
    let magicalNum = Number(input[index]);
    let counter =0;
    let flag = false;
    let noCombinations = true;


    for(let i = numOne; i<=numTwo; i++){
        for(let j = numOne; j<=numTwo; j++){
            counter++;
            if(i+j === magicalNum){
                console.log(`Combination N:${counter} (${i} + ${j} = ${magicalNum})`);
                flag = true;
                noCombinations = false;
                break;
            } 
        }

        if(flag){
            break;
        }
    }

    if(noCombinations){
        console.log(`${counter} combinations - neither equals ${magicalNum}`);
    }
}

solve(["1",
"10",
"5"])




