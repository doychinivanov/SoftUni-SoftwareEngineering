function solve(input) {
    let array = input.split(' ');
    let myObject = new Map();

    for (let iterator of array) {
        iterator = iterator.toLowerCase();
        if(myObject.has(iterator)){
            let existing = myObject.get(iterator); 
            myObject.set(iterator, existing += 1);
        } else {
            myObject.set(iterator, 1);
        }
    }

    let keys = Array.from(myObject.keys())
    .filter( x => myObject.get(x) % 2 !== 0);
    
    return keys.join(' ');
}

console.log(solve('Java C# Php PHP Java PhP 3 C# 3 1 5 C#'))