function solve(array){
    // const pattern = /^>>(?<item>[A-Za-z]+)<<(?<price>[\d?.]+)!(?<quantity>\d+)/g;
    const pattern = /^(?<separator>[>]){2}(?<item>[A-Za-z]+)(?<SecSeparator>[<]{2})(?<price>[\d?.]+)(?<thirdSeparator>[!]){1}(?<quantity>\d+)/g;
    let currentLine = array.shift();
    let total = 0;
    const result = ['Bought furniture:'];

    while(currentLine !== 'Purchase'){
        while((match = pattern.exec(currentLine)) !== null){
            const item = match.groups.item;
            const price = Number(match.groups.price);
            const quantity = Number(match.groups.quantity);

            result.push(item);
            total += price*quantity;
        }

        currentLine = array.shift();
    }
    result.push(`Total money spend: ${total.toFixed(2)}`);

    return result.join('\n');  
}

console.log(solve([ '>>Sofa<<312.23!3', '>>TV<<300!5', '>Invalid<<!5', 'Purchase' ]));