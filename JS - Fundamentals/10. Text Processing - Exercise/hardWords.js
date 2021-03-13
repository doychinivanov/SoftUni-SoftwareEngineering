function solve(array){
    let [letter, words] = array;
    const regEx = new RegExp('[_]+', 'g');
    const matches = letter.match(regEx);
    const wordOrder = [];

    matches.forEach(possibleWord => {
        words.forEach(word => {
            if(possibleWord.length === word.length){
                possibleWord = word;
                wordOrder.push(possibleWord);
            }
        })
    });

    wordOrder.forEach(word => {
        const blank = '_'.repeat(word.length);
        letter = letter.replace(blank, word);
    })

    return letter
}

console.log(solve(['Hi, grandma! I\'m so ____ to write to you. ______ the winter vacation, so _______ things happened. My dad bought me a sled. Mom started a new job as a __________. My brother\'s ankle is ________, and now it bothers me even more. Every night Mom cooks ___ on your recipe because it is the most delicious. I hope this year Santa will _____ me a robot.',
['pie', 'bring', 'glad', 'During', 'amazing', 'pharmacist', 'sprained']]
));