function findTwoSmallest(arr){
    return arr.sort((a,b) => a - b).slice(0, 2).join(' ');
}

console.log(findTwoSmallest([30, 15, 50, 5]));