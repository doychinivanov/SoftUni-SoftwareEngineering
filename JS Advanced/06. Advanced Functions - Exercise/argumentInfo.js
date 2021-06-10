function sortArgs(){
    const typeCount = {};

    for (const arg of arguments) {
        const type = typeof arg;

        console.log(`${type}: ${arg}`);

        if(typeCount.hasOwnProperty(typeof arg) == false){
            typeCount[typeof(arg)] = 1;
        } else {
            typeCount[typeof(arg)]++;
        }
    }

    Object.entries(typeCount).sort((a,b) => b[1] - a[1]).forEach(k=> console.log(`${k[0]} = ${k[1]}`));
}

sortArgs('cat', 42, function () { console.log('Hello world!'); });