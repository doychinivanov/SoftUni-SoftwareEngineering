function fibonacciSeq(n, k){
    const result = [1];

    while(result.length < n){
        let newN = 0;

        for (let i = 0; i < k; i++) {
            if(result.length < k){
                newN = result.reduce((a,b) => a+b, 0)
            } else {
                newN += result[result.length-1-i];
            }   
        }

        result.push(newN);
    }

    return result;
}

console.log(fibonacciSeq(6, 3));