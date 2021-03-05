function solve(array) {
    const result = [];
    const schedule =  array.reduce((acc, cur) => {
        let [day, person] = cur.split(' ');     
        
        if(acc.hasOwnProperty(day)){
            result.push(`Conflict on ${day}!`)
        } else {
            acc[day] = person;
            result.push(`Scheduled for ${day}`)
        }
      
        return acc;
    }, {});

    for (const key in schedule) {
        result.push(`${key} -> ${schedule[key]}`);
    };

    return result.join('\n');
}

console.log(solve(
    ['Monday Peter',
        'Wednesday Bill',
        'Monday Tim',
        'Friday Tim']

));