function solve(arr){
    let sortedArr = arr.sort((a,b) => a-b);
    return sortedArr.slice(0, 2).join(' ');
}

console.log(solve(
    [30, 15, 50, 5]
));