function solve(word, symbol, reference){
    word = word.replace('_', symbol);
    console.log(word === reference ? `Matched` : `Not Matched`);
}

solve(
    'Str_ng', 'I', 'Strong'
)