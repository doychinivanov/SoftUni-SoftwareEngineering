function solve(array, magicSum) {

    for (let i = 0; i < array.length; i++) {
        for (let k = i+1; k < array.length; k++) {
            if(array[i] + array[k] === magicSum){
                console.log(array[i], array[k]);
            }
        }
    }
}

solve(
    [14, 20, 60, 13, 7, 19, 8],
27


)