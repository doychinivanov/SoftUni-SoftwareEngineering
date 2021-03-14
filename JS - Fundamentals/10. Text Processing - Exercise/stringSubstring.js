function solve(word, text){
    word = word.toLowerCase();
    text = text.toLowerCase();

    const regExp = new RegExp(`\\b${word}\\b`, 'g');

    if(text.match(regExp) !== null){
        return word;
    } else {
        return `${word} not found!`
    }
}

console.log(solve('javascript',
'JavaScript is the best programming language'
));