function solve([input]){
    input = input.split(' ');
    const result = [];
    const pattern= /^([a-z]+[\.\-\_]?[a-z]+)@([a-z]+[\.\-\_]?[a-z]+[\.][a-z]+[\.]?[a-z]+)/g;
    
    input.forEach(word=>{
        const match = word.match(pattern);
        
        if(match !== null){
            result.push(match);
        }
    });

    return result.join('\n');
}

console.log(solve(
    [ 'Please contact us at: support@github.com.' ]
));