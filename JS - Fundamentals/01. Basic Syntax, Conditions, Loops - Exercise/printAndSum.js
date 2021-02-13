function solve(x, y){
    let numbers = [];

    for (let i = x; i <= y; i++) {
        numbers.push(i);
    }

    console.log(numbers.join(' '));
    let sum = numbers.reduce((a,b) => a+b);
    console.log(`Sum: ${sum}`);
}

solve(0, 26);