function solve(arr) {
    const train = arr.shift().split(' ').map(Number);
    const capacity = Number(arr.shift());

    arr.forEach(element => {
        if (element.includes('Add')) {
            element = element.split(' ');
            train.push(Number(element[1]));
        } else {
            let people = Number(element);

            for (let i = 0; i < train.length; i++) {
                if (train[i] + people <= capacity) {
                    train[i] += people;
                    break;
                }

            }
        }
    });

    return train.join(' ');
}

console.log(solve(
    ['32 54 21 12 4 0 23',
        '75',
        'Add 10',
        'Add 0',
        '30',
        '10',
        '75'
    ]
));