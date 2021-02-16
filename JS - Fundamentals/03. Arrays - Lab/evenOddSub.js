function solve(array){
    let evenSum = array.filter((x) => x % 2 === 0).reduce((acc, cur) => acc + cur, 0);
    let oddSum = array.filter((x) => x % 2 !== 0).reduce((acc, cur) => acc + cur, 0)

    return evenSum - oddSum;
}

console.log(solve(
    [1,2,3,4,5,6]
));