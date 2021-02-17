function solve(array, rotations){
    let result = array.slice()
    for (let i = 0; i < rotations; i++) {
        let taken = result.shift();
        result.push(taken)
    }

    return result.join(' ')
}

console.log(solve(
    [51, 47, 32, 61, 21], 2
));