function solve(array) {
    let inventory = {};
    inventory = setInventory(array, inventory);
    const result = []



    for (const key in inventory) {
        result.push(`${key} -> ${inventory[key]}`)
    }

    return result.join('\n');

    function setInventory(arr, inventory){
        for (let i = 0; i < arr.length; i++) {
            let resourceType = arr[i];
            i++;
            let quantity = Number(arr[i]);
    
            if(inventory.hasOwnProperty(resourceType)){
                quantity += inventory[resourceType];
            }
    
            inventory[resourceType] = quantity;   
        }

        return inventory;
    }
}

console.log(solve(
    [
        'gold',
        '155',
        'silver',
        '10',
        'copper',
        '17',
        'gold',
        '15'
    ]        
));