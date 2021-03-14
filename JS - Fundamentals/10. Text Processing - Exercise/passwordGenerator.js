function solve(array){
    let [firstWord, secondWord, thirdWord] = array;
    let password = firstWord + secondWord;
    thirdWord = thirdWord.toUpperCase();
    let i = 0;
    
    for (const char of password) {
        if(char === 'a' || char === 'e' || char === 'i' || char === 'o' || char === 'u'){
            password = password.replace(char, thirdWord[i]);
            i++;

            if(i >= thirdWord.length){
                i = 0;
            }
        }
    }

    return `Your generated password is ${password.split('').reverse().join('')}`;
}

console.log(solve(
    [
        'ilovepizza', 'ihatevegetables',
        'orange'
    ]        
));