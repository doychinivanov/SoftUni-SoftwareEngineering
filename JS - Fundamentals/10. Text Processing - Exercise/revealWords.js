function solve(words, text) {
    words.split(', ')
    .forEach(word => {
        const hiddenWord = '*'.repeat(word.length);
        text = text.replace(hiddenWord, word);
    });

    return text;
}

console.log(solve('great, learning',
'softuni is ***** place for ******** new programming languages'
));