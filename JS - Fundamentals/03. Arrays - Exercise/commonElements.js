function solve(array1, array2){
    let result = [];

    array1.forEach(element => {
        if(array2.includes(element)){
            result.push(element);
        }
    });

    return result.join('\n')
}

console.log(solve(
    ['Hey', 'hello', 2, 4, 'Peter', 'e'],
['Petar', 10, 'hey', 4, 'hello', '2']

));