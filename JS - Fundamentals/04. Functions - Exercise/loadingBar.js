function load(num){
    let bar = '%'.repeat(num/10).split('');
    let empty = Array(10 - num/10).fill('.')
    let filledBar = bar.concat(empty).join('');
   
    let result = [];
    if(num/10 === 10){
        result.push(`${num}% Complete!`);
        result.push(`[${filledBar}]`);
    } else {
        result.push(`${num}% [${filledBar}]`);
        result.push(`Still loading...`)
    }

    return result.join('\n')
}

console.log(load(10));