function solve(array) {
    const adressBook =  array.reduce((acc, cur) => {
        let [name, adress] = cur.split(':');       
        acc[name] = adress;
      

        return acc;
    }, {});

    return Object.entries(adressBook)
    .sort(sortAdressBook)
    .reduce((acc, cur) => {
        acc.push(`${cur[0]} -> ${cur[1]}`)

        return acc;
    }, [])
    .join('\n');

    
    function sortAdressBook(a,b){
        return a[0].localeCompare(b[0]);
    }
}

console.log(solve(
    ['Tim:Doe Crossing',
        'Bill:Nelson Place',
        'Peter:Carlyle Ave',
        'Bill:Ornery Rd']
));