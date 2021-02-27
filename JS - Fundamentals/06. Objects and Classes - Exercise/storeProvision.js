function solve(initialProducts, orders){
    const storage = {};
    const outPut = [];

    for (let i = 0; i < initialProducts.length; i+=2) {
        storage[initialProducts[i]] = Number(initialProducts[i+1]);
    }

    for (let i = 0; i < orders.length; i+=2) {
        let quantity = Number(orders[i+1]);
        if(storage.hasOwnProperty(orders[i])){
            quantity += storage[orders[i]];
        }

        storage[orders[i]] = quantity;
        
    }

    for (const key in storage) {
       outPut.push(`${key} -> ${storage[key]}`)
    }

    return outPut.join('\n');
}

console.log(solve(
    [
    'Chips', '5', 'CocaCola', '9', 'Bananas', '14', 'Pasta', '4', 'Beer', '2'
    ],
    [
    'Flour', '44', 'Oil', '12', 'Pasta', '7', 'Tomatoes', '70', 'Bananas', '30'
    ]
));