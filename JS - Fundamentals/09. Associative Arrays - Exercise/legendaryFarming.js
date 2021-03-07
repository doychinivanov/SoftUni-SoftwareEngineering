function solve(input) {
    const array = input.split(' ');
    let storage = { fragments: 0, shards: 0, motes: 0 };
    let junk = {};
    let objective = 250;
    const result = [];
    
    for (let i = 0; i < array.length; i++) {
        let quantity = Number(array[i]);
        i++;
        let material = array[i].toLowerCase();
        
        if(material === 'fragments' || material === 'shards' || material === 'motes'){
            storage[material] += quantity;
        } else {
            if(!junk.hasOwnProperty(material)){
                junk[material] = quantity;
            } else {
                junk[material] += quantity;
            }
        }

        if (storage.shards >= objective) {
            result.push('Shadowmourne obtained!');
            storage.shards -= objective;
            break;
        } else if (storage.fragments >= objective) {
            result.push('Valanyr obtained!');
            storage.fragments -= objective;
            break;
        } else if (storage.motes >= objective) {
            result.push('Dragonwrath obtained!');
            storage.motes -= objective;
            break;
        }
    }

    Object.entries(storage)
    .sort((a,b) => b[1] - a[1] || a[0].localeCompare(b[0]))
    .forEach(element =>{
        result.push(`${element[0]}: ${element[1]}`)
    });

    Object.entries(junk)
    .sort((a,b) => a[0].localeCompare(b[0]))
    .forEach(element => {
        result.push(`${element[0]}: ${element[1]}`)
    });

    return result.join('\n');
}

console.log(solve(
    '3 Motes 5 stones 5 Shards 6 leathers 255 fragments 7 Shards'
));