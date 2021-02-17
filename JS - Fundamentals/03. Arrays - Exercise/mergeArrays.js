function solve(array1, array2){
    let result = [];
    
    for (let i = 0; i < array1.length; i++) {
        if(i%2===0){
            result.push(Number(array1[i]) + Number(array2[i]))
        } else {
            result.push(array1[i] + array2[i])
        }
        
    }

    return result.join(' - ');
}

console.log(solve(
    ['5', '15', '23', '56', '35'],
['17', '22', '87', '36', '11']

));