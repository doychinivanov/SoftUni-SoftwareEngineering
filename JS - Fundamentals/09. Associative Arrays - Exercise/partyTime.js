function solve(array) {
    const result = [];
    const guests = {
        'VIP' : [],
        'Regular': []
    }

    let guest = array.shift();
    while(guest !== 'PARTY'){
        let char = guest[0];
        if(isNaN(char)){
            guests['Regular'].push(guest);
        }else {
            guests['VIP'].push(guest);
        }

        guest = array.shift();
    }

    array.forEach(guest => {
        if(guests['VIP'].includes(guest)){
            const index = guests['VIP'].indexOf(guest);
            guests['VIP'].splice(index, 1);
        } else if(guests['Regular'].includes(guest)) {
            const index = guests['Regular'].indexOf(guest);
            guests['Regular'].splice(index, 1);
        }
    });

    result.push(`${guests['VIP'].length + guests['Regular'].length}\n`);
    result.push(`${guests['VIP'].join('\n')}\n`);
    result.push(guests['Regular'].join('\n'));

    return result.join('');
}

console.log(solve(
    ['7IK9Yo0h',
        '9NoBUajQ',
        'Ce8vwPmE',
        'SVQXQCbc',
        'tSzE5t0p',
        'PARTY',
        '9NoBUajQ',
        'Ce8vwPmE',
        'SVQXQCbc'
    ]
));