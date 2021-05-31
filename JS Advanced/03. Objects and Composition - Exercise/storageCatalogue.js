function createCatalogue(arr){
    const catalogue = {};
    const result = [];

    arr.forEach(line => {
        let [product, price] = line.split(' : ');

        if(catalogue.hasOwnProperty(product[0].toUpperCase()) == false){
            catalogue[product[0].toUpperCase()] = [];
        }

        catalogue[product[0].toUpperCase()].push([product, Number(price)]);
    });

    Object
    .entries(catalogue)
    .sort((a,b) => a[0].localeCompare(b[0]))
    .forEach(element => {
        result.push(element[0]);
        result.push(element[1].sort((a,b)=> a[0].localeCompare(b[0])).map(x => `  ${x.join(': ')}`).join('\n'));
    })

    return result.join('\n');

}

console.log(createCatalogue(['Banana : 2',
'Rubic\'s Cube : 5',
'Raspberry P : 4999',
'Rolex : 100000',
'Rollon : 10',
'Rali Car : 2000000',
'Pesho : 0.000001',
'Barrel : 10']
));