function solve(array){
    let result = [];
    let leftSum = 0;
    let rightSum = array.reduce((acc,curr) => acc+curr,0);
    let index = 0;
    let isFound = false;

    for (let i = 0; i < array.length; i++) {
        rightSum -= array[i];
        
        if(leftSum === rightSum){
            isFound = true;
            index = i;
            break;
        }
        leftSum += array[i];
    }

    isFound ? result.push(index) : result.push('no')

    return result.join('')
}

console.log(solve(
    [1]
));