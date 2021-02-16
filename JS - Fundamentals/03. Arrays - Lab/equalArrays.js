function solve(array, array2){
    let sum = array.map(Number).reduce((acc, cur) => acc + cur, 0)

    let diffrence = 0;
    let areIdentical = true;
    for (let i = 0; i < array.length; i++) {
        if(array[i] !== array2[i]){
            areIdentical = false;
            diffrence = i;
            break;
        }
    }

    let result = [];
    areIdentical ? result.push(`Arrays are identical. Sum: ${sum}`) : result.push(`Arrays are not identical. Found difference at ${diffrence} index`);

    return result.join('')
}

console.log(solve(
    ['1','2','3','4','5'], ['1','2','3','4','5', '6']
));