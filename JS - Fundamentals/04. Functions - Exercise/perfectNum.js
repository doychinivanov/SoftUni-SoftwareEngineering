function solve(num){
    
    let sum = 1;
    for (let i = 2; i <= num/2; i++) {
        num % i === 0 ? sum+=i : sum;  
    }

    return num === sum ? `We have a perfect number!` : `It's not so perfect.`
}

console.log(solve(6));