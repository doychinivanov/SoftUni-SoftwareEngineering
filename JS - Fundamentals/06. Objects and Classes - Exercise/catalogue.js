function solve(arr){
    const catalogue = {};
    const outPut = [];

    arr.forEach(element => {
        let [product, price] = element.split(' : ');
        price = Number(price);
        let currentLetter = product[0].toUpperCase();
        if(!catalogue.hasOwnProperty(currentLetter)){
            catalogue[currentLetter] = [];
        }

        catalogue[currentLetter].push(`${product}: ${price}`);
        catalogue[currentLetter].sort((a,b) => a.localeCompare(b));
    });

    Object.entries(catalogue)
    .sort((a,b) => a[0].localeCompare(b[0]))
    .forEach(letter => {
        outPut.push(`${letter[0]}\n`);
        letter[1].forEach(set=>{
            outPut.push(`  ${set}\n`)
        })
    })

    return outPut.join(''); 
}

console.log(solve(
   [ 'Appricot : 20.4',
'Fridge : 1500',
'TV : 1499',
'Deodorant : 10',
'Boiler : 300',
'Apple : 1.25',
'Anti-Bug Spray : 15',
'T-Shirt : 10']
));