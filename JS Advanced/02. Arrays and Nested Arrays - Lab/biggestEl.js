function findBiggestN(arr){
    const result = [];
    arr.forEach(currentArr => result.push(Math.max(...currentArr)));
    return Math.max(...result);
}

console.log(findBiggestN([[20, 50, 10],
    [8, 33, 145]]
   ));