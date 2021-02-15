function solve(numA, operator, numB){
    let actions = {
        '+' : numA+numB,
        '-' : numA-numB,
        '*' : numA*numB,
        '/' : numA/numB
    }

    let result = actions[operator].toFixed(2);
    console.log(result);
}

solve(5,
    '+',
    10
    )