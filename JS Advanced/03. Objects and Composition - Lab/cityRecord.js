function createCityRecord(cityName, cityPopulation, cityTreasury){
    return {
        name: cityName,
        population: cityPopulation,
        treasury: cityTreasury
    };
}

console.log(createCityRecord('Tortuga', 7000, 15000));