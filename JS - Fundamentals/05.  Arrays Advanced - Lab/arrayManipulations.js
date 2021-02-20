function manipulate(inputArray) {
    const actions = {
        Add : (num, array)=>{
            num = parseToNum(num);
            array.push(num);
            return array;
        },
        Remove: (num, array) => {
            num = parseToNum(num);
            while(array.includes(num)){
                array.splice(array.indexOf(num),1);
            }
            return array;
        },
        RemoveAt: (index, array) => {
            index = parseToNum(index);
            if(checkIndex(index)){
                array.splice(index, 1);
            }
            return array;
        },
        Insert: (num, index, array) => {
            index = parseToNum(index);
            if(checkIndex(index)){
                array.splice(index, 0, num);
            }
            num = parseToNum(num);
            return array;
        }
    }

    let outputArray = inputArray.shift().split(' ');
    outputArray = outputArray.map(Number);
    inputArray.forEach(line => {
        const [command, ...params] = line.split(' ');
        const action = actions[command];
        outputArray = action(...params, outputArray)
    });

    return outputArray.join(' ');

   
   
    function parseToNum (x){
        return Number(x);
    }

    function checkIndex(n){
        return n>-1;
    }
}

console.log(manipulate(
    ['4 19 2 53 6 43',
        'Add 3',
        'Remove 2',
        'RemoveAt 1',
        'Insert 8 3']
));