function solve([input]) {
    const validEmojies = [];
    const allMatchedEmojies = [];
    const pattern = /(::|\*\*)(?<emoji>[A-Z][a-z]{2,})\1/g;
    const digitPattern = /\d/g;

    const treshHold = input.match(digitPattern).map(Number).reduce((a,c) => a*c,1);
    while((match = pattern.exec(input)) !== null){
        const currentEmoji = match.groups.emoji;
        allMatchedEmojies.push(currentEmoji);
        let currentCoolness = 0;
        
        for (let i = 0; i < currentEmoji.length; i++) {
            currentCoolness += currentEmoji[i].charCodeAt();    

        }

        if(currentCoolness > treshHold){
            validEmojies.push(match[0]);
        }
    }
    
    
    
    console.log(`Cool threshold: ${treshHold}`);
    console.log(`${allMatchedEmojies.length} emojis found in the text. The cool ones are:`);
    console.log(validEmojies.join('\n'));
}

solve([
    'In the Sofia Zoo there are 311 animals in total! ::Smiley:: This includes 3 **Tigers**, 1 ::Elephant:, 12 **Monk3ys**, a **Gorilla::, 5 ::fox:es: and 21 different types of :Snak::Es::. ::Mooning:: **Shy**'
])