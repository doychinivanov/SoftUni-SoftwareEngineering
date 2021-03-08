function solve(array) {
    const parking = {};
    const result = []

    array.forEach(element => {
        let [direction, car] = element.split(', ');
        parking[car] = direction;
    });

    for (const key in parking) {
        if(parking[key] === 'OUT'){
            delete parking[key];
        }
    };

    const sorted = Object
    .entries(parking)
    .sort((a,b) => a[0].localeCompare(b[0]));

    if(sorted.length>0){
        sorted.forEach(element=>{
            result.push(element[0]);
        })
    } else{
        result.push('Parking Lot is Empty')
    }
   
    return result.join('\n');
}

console.log(solve(
    ['IN, CA2844AA',
        'IN, CA1234TA',
        'OUT, CA2844AA',
        'IN, CA9999TT',
        'IN, CA2866HI',
        'OUT, CA1234TA',
        'IN, CA2844AA',
        'OUT, CA2866HI',
        'IN, CA9876HH',
        'IN, CA2822UU']
));