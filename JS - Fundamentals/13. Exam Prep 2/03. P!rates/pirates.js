function solve(arr){
    const cities = {};
    const actions = {
        Plunder : (cities, [name, killed, stolen])=>{
            killed = Number(killed);
            stolen = Number(stolen);

            cities[name].population -= killed;
            cities[name].gold -= stolen;
            console.log(`${name} plundered! ${stolen} gold stolen, ${killed} citizens killed.`);
            
            if(cities[name].population <= 0 || cities[name].gold <= 0){
                delete cities[name];
                console.log(`${name} has been wiped off the map!`);
            }
        },
        Prosper : (cities, [name, addedGold]) =>{
            addedGold = Number(addedGold);

            if(addedGold < 0){
                console.log(`Gold added cannot be a negative number!`);
            } else {
                cities[name].gold += addedGold;

                console.log(`${addedGold} gold added to the city treasury. ${name} now has ${cities[name].gold} gold.`);
            }
        }
    }

    while((line = arr.shift()) !== 'Sail'){
        let [name, population, gold] = line.split('||');
        population = Number(population);
        gold = Number(gold);

        if(!cities.hasOwnProperty(name)){
            cities[name] = {population, gold};
        } else {
            cities[name].population += population;
            cities[name].gold += gold;
        }
    }

    while((line = arr.shift()) !== 'End'){
        const [command, ...params] = line.split('=>');
        const action = actions[command];
        action(cities, params);
    }

    if(Object.entries(cities).length > 0){
        console.log(`Ahoy, Captain! There are ${Object.entries(cities).length} wealthy settlements to go to:`);

        Object
        .entries(cities)
        .sort(sortTowns)
        .forEach(town => {
            console.log(`${town[0]} -> Population: ${town[1].population} citizens, Gold: ${town[1].gold} kg`);
        })
    } else {
        console.log('Ahoy, Captain! All targets have been plundered and destroyed!');
    }


    function sortTowns(a, b){
        return b[1].gold - a[1].gold || a[0].localeCompare(b[0])
    }
}

solve([
    'Tortuga||345000||1250',
    'Santo Domingo||240000||630',
    'Havana||410000||1100',
    'Sail',
    'Plunder=>Tortuga=>75000=>380',
    'Prosper=>Santo Domingo=>180',
    'End'
  ])