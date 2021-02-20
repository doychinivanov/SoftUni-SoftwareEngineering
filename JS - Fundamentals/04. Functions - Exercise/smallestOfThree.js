function solve(a, b, c) {
    let array = [];
    array.push(a,b,c);
    array.sort((a,b) => a-b);
    let result = array.shift();
    console.log(result);
}

solve(
    2,
    5,
    3
)