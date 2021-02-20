function solve(array){
    
    array.forEach(element => {
        if(element == element.toString().split('').reverse().join('')){
            console.log(`true`);
        } else {
            console.log(`false`);
        }
    });
}

solve(
    [123,323,421,121]
)