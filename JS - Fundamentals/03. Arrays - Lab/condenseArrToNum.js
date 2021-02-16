function solve(array){
    let condensed = [];

    while(array.length > 1){
        for (let i = 0; i < array.length-1; i++) {
            condensed.push(array[i] + array[i+1]);
        }

        array = condensed;
        condensed = []
    }

    return array.join('')
}

console.log(solve(
    [2,10,3]
));