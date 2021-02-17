function solve(array){
    array = array[0].split('|');
    let health = 100;
    let coins = 0;
    let rooms = 0;
    
    for (let i = 0; i < array.length; i++) {
        let [command, value] = array[i].split(' ');
        value = Number(value);
        rooms++;

        if(command === 'potion'){
            if(health + value > 100){
                value = 100 - health;
            }
            health+=value;
            console.log(`You healed for ${value} hp.`);
            console.log(`Current health: ${health} hp.`);
        } else if(command === 'chest'){
            coins += value;
            console.log(`You found ${value} coins.`);
        } else {
            let monster = command;
            health-=value;
            if(health > 0){
                console.log(`You slayed ${monster}.`);
            } else {
                console.log(`You died! Killed by ${monster}.`);
                break;
            }
        }
    }

    if(health <=0){
        console.log(`Best room: ${rooms}`);
    } else {
        console.log(`You've made it!`);
        console.log(`Coins: ${coins}`);
        console.log(`Health: ${health}`);
    }
}

solve(
    ["rat 10|bat 20|potion 10|rat 10|chest 100|boss 70|chest 1000"]
)