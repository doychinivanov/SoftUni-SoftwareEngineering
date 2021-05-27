function printEveryN(arr, n){
    const result = [];

    for (let i = 0; i < arr.length; i+=n) {
        result.push(arr[i])
    }

    return result;
}

console.log(printEveryN(['5', 
'20', 
'31', 
'4', 
'20'], 
2
));