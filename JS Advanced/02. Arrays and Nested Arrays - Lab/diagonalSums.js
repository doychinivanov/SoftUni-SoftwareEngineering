function sumDiagonals(arr){
    let firstSum = 0;
    let secondSum = 0;

    for (let i = 0; i < arr.length; i++) {
        firstSum += arr[i][i];
        secondSum += arr[i][arr.length -1 - i];
    }

    return [firstSum, secondSum].join(' ');
}

console.log(sumDiagonals([[20, 40], [10, 60]]));