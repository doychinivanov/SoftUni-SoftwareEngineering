function solve(text){
    const result = [];

    for (let i = 0; i < text.length; i++) {
        if(text[i] !== text[i+1]){
            result.push(text[i]);
        }
    }

    return result.join('')
}

console.log(solve('aaaaabbbbbcdddeeeedssaa'));