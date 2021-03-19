function solve(array) {
    let currentLine = array.shift();
    let total = 0;
    const result = [];
    const pattern = /^%(?<name>[A-Z][a-z]+)%([^\|\$%\.]+)?<(?<product>\w+)>([^\|\$%\.]+)?\|(?<quantity>[0-9]+)\|([^\|\$%\.\d]+)?(?<price>\d+[\.]?[0-9]+?)\$/g;

    while (currentLine !== 'end of shift') {
        while ((match = pattern.exec(currentLine)) !== null) {
            const name = match.groups.name;
            const product = match.groups.product;
            const quantity = Number(match.groups.quantity);
            const price = Number(match.groups.price);

            total += price * quantity;

            let personalPrice = Number(quantity) * Number(price);
            result.push(`${name}: ${product} - ${personalPrice.toFixed(2)}`);

        }

        currentLine = array.shift();
    }
    result.push(`Total income: ${total.toFixed(2)}`);
    return result.join('\n');
}

console.log(solve(
    [
        '%George%<Croissant>|2|10.3$',
        '%Peter%<Gum>|1|1.3$',
        '%Peter%<Water>|1|1.3$',
        '%Peter%<Water>|1|1.3$',
        '%Maria%<Cola>|1|2.4$',
        'end of shift'
    ]
));