function solve(arr) {
    let parts = arr.shift().split('|');
    const actions = {
        Move: (arr, [direction, index])=>{
            index = Number(index);
            if(index>=0 && index<arr.length){
                if(direction === 'Right'){
                    if(index !== arr.length-1){
                        let value = arr.splice(index, 1);
                        arr.splice(index+1, 0, ...value);
                    }
                }

                if(direction === 'Left'){
                    if(index !== 0){
                        let value = arr.splice(index, 1);
                        arr.splice(index-1, 0, ...value);
                    }
                }
            }

            return arr;
        },
        Check: (arr, [condition])=>{
            if(condition === 'Odd'){
                const oddPosition = arr.filter((x, i) => {
                    if(i %2 !==0){
                        return x;
                    }
                })

                console.log(oddPosition.join(' '));
            }

            if(condition === "Even"){
                const evenPosition = arr.filter((x, i, arr) => {
                    if(i %2 ===0){
                        return x;
                    }
                })

                console.log(evenPosition.join(' '));
            }

            return arr;
        }
    }
    
    
    arr.forEach(line => {
        let [command, ...params] = line.split(' ');
        if(command!=='Done'){
            parts = actions[command](parts, params)
        }
    });

    return `You crafted ${parts.join('')}!`;
}

console.log(solve(
    (["ri|As|er|hb|ng",
    "Move Left 1",
    "Move Right 2",
    "Move Right 3",
    "Move Left 2",
    "Done"])
));