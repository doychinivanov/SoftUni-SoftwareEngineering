function solve(arr){
    const uniqueArr = [...new Set(arr)];

    return uniqueArr.join(' ');
}

console.log(solve([1, 2, 3, 4]));
console.log(solve([7, 8, 9, 7, 2, 3, 4, 1, 2]));