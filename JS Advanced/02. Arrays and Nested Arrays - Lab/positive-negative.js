function prependNum(arr){
    const result = [];
    arr.forEach(x => x < 0 ? result.unshift(x) : result.push(x));

    return result.join('\n');
}

console.log(prependNum([7, -2, 8, 9]));