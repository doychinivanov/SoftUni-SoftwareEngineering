function solve (arr){
    let result = [];
    let arrCopy = arr.slice();
    arr.sort((a,b) => a-b);

    for (let i = 0; i < arrCopy.length/2; i++) {
        let biggest = arr.pop();
        let smallest = arr.shift();

        result.push(biggest);
        result.push(smallest);
    }

    console.log(result.join(" "));
}

solve([1, 21, 3, 52, 69, 63, 31, 2, 18, 94]);