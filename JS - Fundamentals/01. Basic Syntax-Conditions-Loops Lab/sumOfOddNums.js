function solve(endNumber){
    let oddNums = [];
    let i = 1;

    while(oddNums.length < endNumber){
        oddNums.push(i);
        i += 2;
    }

    console.log(oddNums.join('\n'));
    console.log(`Sum: ${oddNums.reduce((a,b) => a+b, 0)}`);
}

solve(5)