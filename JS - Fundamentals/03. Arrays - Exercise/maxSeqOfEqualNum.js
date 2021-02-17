function solve(array) {
    let result = [];


    for (let i = 0; i < array.length; i++) {
        let currentResult = [array[i]];
        for (let k = i + 1; k < array.length; k++) {
            if (array[i] === array[k]) {
                currentResult.push(array[k])
            } else {
                break;
            }
        }

        if(result.length < currentResult.length){
            result = currentResult;
        }
    }

    return result.join(' ')

}

console.log(solve(
    [2, 1, 1, 2, 3, 3, 2, 2, 2, 1]
));