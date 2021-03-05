function solve(array) {
    const result = [];
    const neighbors = array.shift().split(', ');
    const neighborhoods = {};

    neighbors.forEach(element => {
        neighborhoods[element] = [];
    });

    array.forEach(element => {
        let [street, person] = element.split(' - ');
        
        if(neighborhoods.hasOwnProperty(street)){
            neighborhoods[street].push(person);
        }
    });

    Object
    .entries(neighborhoods)
    .sort(sortNeighbors)
    .forEach(element=>{
        result.push(`${element[0]}: ${element[1].length}`)
            element[1].forEach(person => {
                result.push(`--${person}`)
            })
    });

    return result.join('\n');

    function sortNeighbors(a,b){
        return b[1].length - a[1].length;
    }
}

console.log(solve(
    ['Abbey Street, Herald Street, Bright Mews',
        'Bright Mews - Garry',
        'Bright Mews - Andrea',
        'Invalid Street - Tommy',
        'Abbey Street - Billy']
));