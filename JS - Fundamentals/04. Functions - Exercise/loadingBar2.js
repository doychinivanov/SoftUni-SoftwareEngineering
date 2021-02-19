function load (n){
    function emptyBar(){
        let result = [];
        for(let i = 0; i < 10; i++){
            result.push(".");
        }
        return result;
    }

    function fillBar (n){
        let filled = emptyBar();
        for(let i = 0; i<(n/10); i++){
            filled.pop();
            filled.unshift("%")
        }
        return filled.join("");
    }

    let outPut = [];
    if(n === 100){
        outPut.push(`${n}% Complete!`);
        outPut.push(`[${fillBar(n)}]`)
    } else {
        outPut.push(`${n}% [${fillBar(n)}]`);
        outPut.push(`Still loading...`);
    }

    return outPut.join("\n")
}

console.log(load(15));