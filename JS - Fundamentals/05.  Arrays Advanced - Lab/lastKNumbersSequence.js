function solve(n, k){
    // n is the length where k is the number of numbers to be summed

    const result = [1];

    while(result.length < n){
        let newNumber = result.slice(-k).reduce((a,c) => a+c,0);
        result.push(newNumber);
    }

    return result.join(' ');
}

console.log(solve(6, 3));