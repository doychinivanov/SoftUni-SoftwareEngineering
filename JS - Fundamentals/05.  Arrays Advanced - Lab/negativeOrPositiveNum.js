function solve (arr){
    const result = [];

    arr.forEach(x => {
        x < 0 ? result.unshift(x) : result.push(x);
    });

    return result.join('\n');
}

console.log(solve(
    [7, -2, 8, 9]
));