function solve(char1, char2) {
    let smallest = Math.min(char1.charCodeAt(), char2.charCodeAt());
    let bigger = Math.max(char1.charCodeAt(), char2.charCodeAt());
    let result = [];
   
    for (let index = smallest +1; index < bigger; index++){
       result.push(String.fromCharCode(index));     
    }

    return result.join(' ')
}

console.log(solve(
    'C',
'#'
));