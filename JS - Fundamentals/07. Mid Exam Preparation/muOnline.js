function solve(arr) {
    const hero = {
        health: 100,
        bitcoins: 0,
        room: 0,
        isAlive : true
    }

    arr.split('|').forEach(line => {
        let [action, value] = line.split(' ');
        value = Number(value);

        if(hero.isAlive){
            if(action === 'potion'){
                if(hero.health + value > 100){
                    value = 100 - hero.health;
                }
                hero.health += value;
                hero.room++
                console.log(`You healed for ${value} hp.`);
                console.log(`Current health: ${hero.health} hp.`);
            } else if(action === 'chest'){
                hero.bitcoins += value;
                hero.room++;
                console.log(`You found ${value} bitcoins.`);
            } else {
                if(hero.health - value > 0){
                    hero.health -= value;
                    hero.room++
                    console.log(`You slayed ${action}.`);
                } else {
                    hero.isAlive = false;
                    hero.room++;
                    console.log(`You died! Killed by ${action}.`);
                    console.log(`Best room: ${hero.room}`);
                }
            }
        }
    });

    if(hero.isAlive){
        console.log(`You've made it!`);
        console.log(`Bitcoins: ${hero.bitcoins}`);
        console.log(`Health: ${hero.health}`);
    }
}

solve(
    'cat 10|potion 30|orc 10|chest 10|snake 25|chest 110' 
)