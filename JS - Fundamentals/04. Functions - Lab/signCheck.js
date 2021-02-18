function solve(a, b, c) {
    let multiplication = a * b * c;
    if(multiplication === -0){
        multiplication = 0;
    }
    let result = multiplication >= 0 ? `Positive` : `Negative`;

    return result
}

console.log(solve(
    1,
    0,
    -1
));