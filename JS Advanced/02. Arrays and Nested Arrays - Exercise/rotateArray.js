function rotate(arr, n){
    for (let i = 0; i < n; i++) {
        arr.unshift(arr.pop());
    }

    return arr.join(' ');
}

console.log(rotate(['Banana', 
'Orange', 
'Coconut', 
'Apple'], 
15
));