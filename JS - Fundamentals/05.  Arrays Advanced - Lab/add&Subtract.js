function solve(arr){
    arr = arr.map(Number);
    return arr.shift() + arr.pop();
}

console.log(solve(
    ['20', '30', '40']
));