function solve(arr) {
    const amountOfShops = arr.shift();
    const result = [];
    let totalAmount = 0;

    for (let i = 0; i < amountOfShops; i++) {
        const pricePerCapsule = arr.shift();
        const workingDays = arr.shift();
        const capsuleAmount = arr.shift();

        const priceOfCurrentOrder = (workingDays * capsuleAmount) * pricePerCapsule;
        totalAmount += priceOfCurrentOrder;
        result.push(`The price for the coffee is: $${priceOfCurrentOrder.toFixed(2)}`);
    }

    result.push(`Total: $${totalAmount.toFixed(2)}`);

    return result.join('\n');
}

console.log(solve(
    ([2,
        4.99,
        31,
        3,
        0.35,
        31,
        5])
));