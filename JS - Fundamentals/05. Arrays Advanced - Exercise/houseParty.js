function solve(arr) {
    const guests = [];

    arr.forEach(line => {
        const currentGuest = line.split(' ')[0];

        if (!line.includes('not')) {
            if (guests.includes(currentGuest)) {
                console.log(`${currentGuest} is already in the list!`);
            } else {
                guests.push(currentGuest);
            }
        } else {
            if (guests.includes(currentGuest)) {
                const index = guests.indexOf(currentGuest);
                guests.splice(index, 1);
            } else {
                console.log(`${currentGuest} is not in the list!`);
            }
        }

    });

    return guests.join('\n');
}

console.log(solve(
    ['Tom is going!',
        'Annie is going!',
        'Tom is going!',
        'Garry is going!',
        'Jerry is going!']
));

console.log(`-----------------`);

console.log(solve(
    ['Allie is going!',
        'George is going!',
        'John is not going!',
        'George is not going!']
));