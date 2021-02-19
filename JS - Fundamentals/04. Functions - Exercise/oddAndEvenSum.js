function solve(num){
    const arrayNum = num.toString().split('')
    const evenSum = arrayNum.map(Number).filter(x => x%2==0).reduce((a,c) => a+c,0);
    const oddSum = arrayNum.map(Number).filter(x => x%2!==0).reduce((a,c) => a+c,0)
    
    return `Odd sum = ${oddSum}, Even sum = ${evenSum}`
}

console.log(solve(
    1000435
));