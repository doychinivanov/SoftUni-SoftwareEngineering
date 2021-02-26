function solve(arr) {
    const objectEmployees = {};
    const result = [];

    arr.forEach(element => {
        if(!objectEmployees.hasOwnProperty(element)){
            objectEmployees[element] = '';
        }

        objectEmployees[element] = element.length;
    });

    for (const key in objectEmployees) {
        result.push(`Name: ${key} -- Personal Number: ${objectEmployees[key]}`)
    }

    return result.join('\n');
}

console.log(solve(
    [
        'Silas Butler',
        'Adnaan Buckley',
        'Juan Peterson',
        'Brendan Villarreal'
    ]
));