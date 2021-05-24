function manipulateOdd(arr){
    return arr
    .map(x=> x.toString())
    .filter((v, i) => i % 2 == 0 ? '' : v)
    .map(Number)
    .map(x => x * 2)
    .reverse()
    .join(' ');
}

console.log(manipulateOdd([3, 0, 10, 4, 7, 3]));