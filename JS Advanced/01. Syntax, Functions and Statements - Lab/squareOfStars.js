function printStars(n){
    n = Number(n);
    const output = [];

    for (let i = 0; i < n; i++) {
        let line = '';
        for (let j = 0; j < n; j++) {
            line += '* ';
        }
        
        output.push(line);
    }

    return output.join('\n');
}

console.log(printStars(2));