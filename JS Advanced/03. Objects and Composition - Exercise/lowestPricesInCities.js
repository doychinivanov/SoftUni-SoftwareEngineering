function findLowest(arr){
    const catalog = new Map();
    const result = []

    arr.forEach(line => {
        let [town, product, price] = line.split(' | ');

        if(catalog.has(product) == false){
            catalog.set(product, new Map());
        } 

        catalog.get(product).set(town, Number(price));
    });

    for(let [key, value] of catalog){
        const lowest = [...value].reduce((acc, cur) => {
            if(acc[1] < cur[1]){
                return acc;
            } else if(acc[1] > cur[1]){
                return cur;
            }

            return acc;
        })

        result.push(`${key} -> ${lowest[1]} (${lowest[0]})`);
    }

    return result.join('\n');
}

console.log(findLowest(['Sofia City | Audi | 100000',
    'Sofia City | BMW | 100000',
    'Sofia City | Mitsubishi | 10000',
    'Sofia City | Mercedes | 10000',
    'Sofia City | NoOffenseToCarLovers | 0',
    'Mexico City | Audi | 1000',
    'Mexico City | BMW | 99999',
    'New York City | Mitsubishi | 10000',
    'New York City | Mitsubishi | 1000',
    'Mexico City | Audi | 100000',
    'Washington City | Mercedes | 1000']));