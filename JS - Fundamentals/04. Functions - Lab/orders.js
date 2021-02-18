function solve(item, quantity) {
    let inventory = {
        coffee : 1.5,
        water : 1,
        coke : 1.4,
        snacks : 2
    }

    return (inventory[item] * quantity).toFixed(2);
}

console.log(solve(
    'water',
    5
));