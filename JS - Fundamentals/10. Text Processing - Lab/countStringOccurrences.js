function solve(text, word) {
    const regex = new RegExp(`\\b${word}\\b`, 'g');
    const result = text.match(regex);

    if (result != null) {
        return result.length
    } else {
        return 0;
    }
}

console.log(solve("This is a word and it also is a sentence", "is"));