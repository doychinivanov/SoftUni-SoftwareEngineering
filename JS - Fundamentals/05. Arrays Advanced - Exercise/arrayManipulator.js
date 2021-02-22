function manipulate(array, commands) {
    const actions = {
        add: (arr, index, el) => {
            index = Number(index);
            arr.splice(index, 0, Number(el));
            return arr;
        },
        addMany: (arr, index, ...params) => {
            index = Number(index)
            params = params.map(Number);
            arr.splice(index, 0, ...params);
            return arr;
        },
        contains: (arr, el) => {
            el = Number(el);
            let index = arr.indexOf(el)
            console.log(index);
        },
        shift: (arr, position) => {
            position = Number(position);
            for (let i = 0; i < position; i++) {
                let element = arr.shift();
                arr.push(element);
            }
            
            return arr;
        },
        sumPairs: (arr) => {
            let newArr = [];
            for (let q = 0; q < arr.length; q +=2) {
                let sum = 0;
                let isNaN = false;
                for (let h = q +1; h <= arr.length; h +=2) {
                    let type = typeof arr[h]
                    if(type === 'undefined'){
                        isNaN = true;
                        break;
                    } else{
                        sum = arr[q] + arr[h];
                        break; 
                    }
                }

                if(isNaN){
                    newArr.push(arr[q])
                } else {
                    newArr.push(sum);
                }
            }
            array=newArr;

            return array;
        },
        print: (arr) => {
            console.log('[ ' + arr.join(', ') + ' ]');;
        },
        remove: (arr, index) => {
            index = Number(index);
            arr.splice(index, 1);
            return arr;
        }
    }

    let result = ''
    commands.forEach(line => {
        let [command, ...params] = line.split(' ');
        let action = actions[command];
        result = action(array, ...params);
    })

}

(manipulate(
    [2, 2, 4, 2, 4],
    ["add 1 4", "sumPairs", "print"]
))