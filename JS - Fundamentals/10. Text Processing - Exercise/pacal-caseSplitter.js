function solve(text){
    const regExp = new RegExp('[A-Z]', 'g');
    let capIndex = 0;
    const result = [];

    for (let i = 1; i < text.length; i++) {
        if(text[i].match(regExp) !== null){
            const word = text.substring(capIndex, i);
            capIndex = i;
            result.push(word);
        }
    }

    result.push(text.substring(capIndex, text.length))

    return result.join(', ');
}

console.log(solve('SplitMeIfYouCanHaHaYouCantOrYouCan'));