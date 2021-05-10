function solve(arg){
    let text = String(arg);
    let result = 0;

    for(let i = 0; i < text.length; i++){
        let ch = text[i];
        switch(ch){
            case "a": result++; break;
            case "e": result += 2; break;
            case "i": result += 3; break;
            case "o": result += 4; break;
            case "u": result += 5; break;
        }
    }
    console.log(result);
}

solve("SoftUni")