function solve(text){
    const regExp = new RegExp('#[a-zA-Z]+\\b', 'g');
    const words = text.match(regExp);
    const result = [];

    words.forEach(word => {
        result.push(word.substring(1));
    });

    return result.join('\n');
}

console.log(solve('Nowadays everyone uses # to tag a #special word in #socialMedia'));