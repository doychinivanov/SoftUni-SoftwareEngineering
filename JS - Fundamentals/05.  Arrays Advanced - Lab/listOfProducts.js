function solve(arr){
    const sortedArr = arr.sort();
    return sortedArr.map((x,i) => `${i+1}.${x}`).join('\n');
}

console.log(solve(
    ["Potatoes", "Tomatoes", "Onions", "Apples", 'apples']
));