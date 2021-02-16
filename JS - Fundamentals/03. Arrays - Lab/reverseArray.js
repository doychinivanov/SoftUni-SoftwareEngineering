function solve(n, array){
    array2 = array.slice(0, n)
    
    return array2.reverse().join(' ')
}

console.log(solve(
    3, [10, 20, 30, 40, 50]
));