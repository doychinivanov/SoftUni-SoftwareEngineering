function solve(array){
    let result = [];

    for (let i = 0; i < array.length; i++) {
        let isBigger = true;
        for(let k = i+1; k < array.length; k++){
            if(array[i]<=array[k]){
                isBigger = false
            }
        }
        
        if(isBigger){
            result.push(array[i])
        }
    }

    return result.join(' ')
}

console.log(solve(
    [41, 41, 34, 20]
));