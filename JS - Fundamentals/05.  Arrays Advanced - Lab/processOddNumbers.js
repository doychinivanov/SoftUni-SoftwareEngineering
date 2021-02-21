function solve(arr){
    const oddPositionArray = arr.filter((x,i) => (i%2===0 ? '' : x));
    return oddPositionArray.map(x=>x*2).reverse().join(' ');
}

console.log(solve(
    [10, 15, 20, 25]
));