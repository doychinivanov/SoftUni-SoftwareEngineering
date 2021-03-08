function solve(array) {
    const result = [];
    const searchedWords = array.shift().split(' ');
    const dictionary = {};

    searchedWords.forEach(word => {
        if(!dictionary.hasOwnProperty(word)){
            dictionary[word] = 0;
        }
    });

    array.forEach(word=>{
        if(dictionary.hasOwnProperty(word)){
            dictionary[word]++;
        }
    })

    Object
    .entries(dictionary)
    .sort(sortDictionary)
    .forEach(word=>{
        result.push(`${word[0]} - ${word[1]}`)
    });

    return result.join('\n');

    function sortDictionary(a,b){
        return b[1] - a[1];
    }

}

console.log(solve(
    [
        'this sentence', 'In', 'this', 'sentence', 'you', 'have', 'to', 'count', 'the', 'occurances', 'of', 'the'
        , 'words', 'this', 'and', 'sentence', 'because', 'this', 'is', 'your', 'task'
    ]
));