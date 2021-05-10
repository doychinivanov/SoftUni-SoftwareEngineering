function solve(arg){
    let text = String(arg);
    let sum = 0;

    for(let i=0; i<text.length; i++){        
        if(text[i] === " "){
            sum++
        }
    }

    let words = sum + 1;

    if(words>10){
        console.log(`The message is too long to be send! Has ${words} words.`);
    } else{
        console.log(`The message was send successfully!`);
    }
}

solve("This message has exactly eleven words. One more as it's allowed!")