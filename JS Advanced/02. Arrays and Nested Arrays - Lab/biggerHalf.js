function findBiggerHalf(arr){
    return arr.sort((a,b) => a - b).slice(arr.length/2);
}

console.log(findBiggerHalf([3, 19, 14, 7, 2, 19, 6]));