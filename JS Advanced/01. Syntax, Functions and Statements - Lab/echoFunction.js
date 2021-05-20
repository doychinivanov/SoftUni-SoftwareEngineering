function printLength(input){
    const result = [];
    result.push(input.length);
    result.push(input);

    return result.join('\n');
}

console.log(printLength('Hello, JavaScript!'));