function solve(arr) {
    const actions = {
        CastSpell : (heroes, [name, mpNeeded, spellName])=> {
            const currentHero = heroes[name];
            mpNeeded = Number(mpNeeded);

            if(currentHero.mp >= mpNeeded){
                currentHero.mp -= mpNeeded;
                console.log(`${name} has successfully cast ${spellName} and now has ${currentHero.mp} MP!`);
            } else {
                console.log(`${name} does not have enough MP to cast ${spellName}!`);
            }
        },
        TakeDamage : (heroes, [name, damageTaken, attacker]) =>{
            const currentHero = heroes[name];
            damageTaken = Number(damageTaken);
            currentHero.hp -= damageTaken

            if(currentHero.hp > 0 ){
                console.log(`${name} was hit for ${damageTaken} HP by ${attacker} and now has ${currentHero.hp} HP left!`);
            } else {
                delete heroes[name];
                console.log(`${name} has been killed by ${attacker}!`);
            }
        },
        Recharge : (heroes, [name, mpCharge])=>{
            const currentHero = heroes[name];
            mpCharge = Number(mpCharge);

            if(currentHero.mp + mpCharge > 200){
                mpCharge = 200 - currentHero.mp;
            }

            currentHero.mp = Math.min(currentHero.mp + mpCharge, 200);
            console.log(`${name} recharged for ${mpCharge} MP!`);
        },
        Heal: (heroes, [name, hpCharge]) => {
            const currentHero = heroes[name];
            hpCharge = Number(hpCharge);

            if(currentHero.hp + hpCharge > 100){
                hpCharge = 100 - currentHero.hp;
            }

            currentHero.hp = Math.min(currentHero.hp + hpCharge, 100);
            console.log(`${name} healed for ${hpCharge} HP!`);
        }
    }
    const heroes = {};

    const numberOfHeroes = Number(arr.shift());

    for (let i = 0; i < numberOfHeroes; i++) {
        const [name, hp, mp] = arr.shift().split(' ');

        heroes[name] = {hp: Number(hp), mp: Number(mp)};
    }

    
    if(arr.length > 0 ){
        while(arr.length > 0 && arr[0] != 'End'){
            const [command, ...params] = arr.shift().split(' - ');
            const action = actions[command];
            action(heroes, params);
        }
    }

    Object
    .entries(heroes)
    .sort(CompareHeroes)
    .forEach(x => {
        console.log(x[0]);
        console.log(`  HP: ${x[1].hp}`);
        console.log(`  MP: ${x[1].mp}`);
    });


    function CompareHeroes(a, b){
        return (b[1].hp - a[1].hp) || a[0].localeCompare(b[0]);
    }
}

solve(
    [
        '2',
        'Solmyr 85 120',
        'Kyrre 99 50',
        'Heal - Solmyr - 10',
        'Recharge - Solmyr - 50',
        'TakeDamage - Kyrre - 66 - Orc',
        'CastSpell - Kyrre - 15 - ViewEarth',
        'End'
    ]
);