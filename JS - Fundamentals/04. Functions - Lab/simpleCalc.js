function solve(num1, num2, operator) {
    let actions = {
        'multiply' : num1 * num2,
        'divide' : num1/num2,
        'add' : num1 + num2,
        'subtract' : num1-num2
    }

    return actions[operator]
}

console.log(solve(
    50,
    13,
    'subtract'
));