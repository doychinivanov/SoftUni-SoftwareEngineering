function solve(arr) {
    const inventory = arr.shift().split(' ');

    const actions = {
        Buy: (array, item) =>{
            if(!array.includes(item)){
                array.push(item);
            }

            return array;
        },
        Trash: (array, item) => {
            if(array.includes(item)){
                let index = array.indexOf(item);
                array.splice(index, 1);
            }

            return array;
        },
        Repair: (array, item) =>{
            if(array.includes(item)){
                let index = array.indexOf(item);
                let repaired = array.splice(index, 1);
                array.push(...repaired);
            }

            return array;
        },
        Upgrade: (array, item) =>{
            let [object, upgrade] = item.split('-')
            if(array.includes(object)){
                const upgratedItem = `${object}:${upgrade}`
                let index = array.indexOf(object);
                array.splice(index+1, 0, upgratedItem);
            }

            return array;
        }
    }
    
    arr.forEach(line => {
        let [command, item] = line.split(' ');
        let action = actions[command];
        action(inventory, item);
    });

    return inventory.join(' ');
}

console.log(solve(
    ['SWORD Shield Spear',
        'Buy Bag',
        'Trash Shield',
        'Repair Spear',
        'Upgrade SWORD-Steel']
))