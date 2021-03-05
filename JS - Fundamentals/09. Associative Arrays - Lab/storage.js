function solve(array) {
    const storage = new Map();
    const result = [];

    array.forEach(element => {
        let [product, quantity] = element.split(' ');
        quantity = Number(quantity);

        if(storage.has(product)){
            storage.set(product, storage.get(product) + quantity);
        } else {
            storage.set(product, quantity);
        }
    });

    for (let [product, quantity] of storage) {
        result.push(`${product} -> ${quantity}`)
    }

    return result.join('\n');
}

console.log(solve(
    ['tomatoes 10',
    'coffee 5',
    'olives 100',
    'coffee 40']
));