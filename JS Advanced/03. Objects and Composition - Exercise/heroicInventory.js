function makeInventory(arr){
    const result = [];

    arr.forEach(line => {
        let [heroName, heroLevel, ...inventory] = line.split(' / ');
        
        result.push({
            name: heroName,
            level: Number(heroLevel),
            items: inventory.join('') ? inventory.join(' ').split(', ') : []});
    });

    return JSON.stringify(result);
}

console.log(makeInventory(['Isacc / 25 / Apple, GravityGun',
'Derek / 12 / BarrelVest, DestructionSword',
'Hes / 1 / Desolator, Sentinel, Antara']
));