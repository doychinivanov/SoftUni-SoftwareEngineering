function getFibonator(){
    let number = 0;
    let next = 1

    return function fib(){
        let result = number + next;
        number = next;
        next = result;
        return number;
    }
}

let fib = getFibonator();
console.log(fib()); // 1
console.log(fib()); // 1
console.log(fib()); // 2
console.log(fib()); // 3
console.log(fib()); // 5
console.log(fib()); // 8
console.log(fib()); // 13
