function solve(a, b, c) {

    let combined = sum(a,b);
    return subtract(combined, c);

    function sum(x,y){
        return x + y;
    }

    function subtract(x,y){
        return x - y;
    }
}

console.log(solve(
    23,
    6,
    10
));