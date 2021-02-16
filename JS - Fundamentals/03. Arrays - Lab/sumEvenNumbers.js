function solve(array) {
    return array.map(Number)
        .filter((x) => x % 2 === 0)
        .reduce((acc, cur) => acc + cur, 0)
}

console.log(solve(
    ['1', '2', '3', '4', '5', '6']
));