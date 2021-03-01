function manipulate(arr) {
    const actions = {
        swap: (arr, [firtsIndex, secondIndex]) => { 
            const firstEl = arr[Number(firtsIndex)];
            const secondEl = arr[Number(secondIndex)];

            arr[firtsIndex] = secondEl;
            arr[secondIndex] = firstEl;

            return arr;
        },
        multiply: (arr, [firtsIndex, secondIndex]) => {
            const result = Number(arr[firtsIndex]) * Number(arr[secondIndex]);
            arr[firtsIndex] = result;
            return arr;
         },
        decrease: (arr) => {
            return arr.map(x => x-1)
        }
    }

    let array = arr.shift().split(' ').map(Number);

    arr.map(x => x.split(' '))
    .forEach(command => {
        let [action, ...params] = command;
        if(action !== 'end'){
            array = actions[action](array, params)
        }
    });

    return array.join(', ')
}

console.log(manipulate(
    [
        '1 2 3 4',
        'swap 0 1',
        'swap 1 2',
        'swap 2 3',
        'multiply 1 2',
        'decrease',
        'end'
      ]      
));