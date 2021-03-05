function solve(array) {
    const result = [];
    const wordObj = array.reduce((acc, cur) => {  
        if(!acc.hasOwnProperty(cur)){
            acc[cur] = 1;
        } else {
            acc[cur]++
        }

        return acc;
    }, {});

    Object.entries(wordObj)
    .sort(sortWords)
    .forEach(word => {
        result.push(`${word[0]} -> ${word[1]} times`)
    });;

    return result.join('\n');

    function sortWords(a,b){
        return b[1] - a[1];
    }
}

console.log(solve(
    ["Here", "is", "the", "first", "sentence", "Here", "is", "another", "sentence", "And", "finally", "the", "third", "sentence"]
));