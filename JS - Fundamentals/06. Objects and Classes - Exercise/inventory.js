function solve(arr) {
    const heroes = [];
    const outPut = [];

    arr.forEach(element => {
        const currentHero = {};
        let [heroName, heroLevel, items] = element.split(' / ');
        items = items.split(', ').sort((a,b)=>a.localeCompare(b)).join(', ');
        currentHero.hero = heroName;
        currentHero.level = heroLevel;
        currentHero.items = items;
        heroes.push(currentHero);
    });

    heroes
    .sort((a,b)=> a.level - b.level)
    .forEach(hero => {
        outPut.push(`Hero: ${hero.hero}\n`);
        outPut.push(`level => ${hero.level}\n`);
        outPut.push(`items => ${hero.items}\n`);
    })

    return outPut.join('')
}

console.log(solve(
    [
        "Isacc / 25 / Apple, GravityGun",
        "Derek / 12 / BarrelVest, DestructionSword",
        "Hes / 1 / Desolator, Sentinel, Antara"
    ]
));