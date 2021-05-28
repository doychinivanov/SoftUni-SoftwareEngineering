function cityTaxes(cityName, cityPopulation, cityTreasury){
    return {
        name: cityName,
        population: cityPopulation,
        treasury: cityTreasury,
        taxRate: 10,
        collectTaxes() {
            this.treasury += this.population * this.taxRate;
        },
        applyGrowth(percent){
            this.population += Math.floor(this.population * percent / 100);
        },
        applyRecession(percent){
            this.treasury -= Math.ceil(this.treasury * percent / 100);
        }
    }
}


const city = cityTaxes('Tortuga', 7000, 15000);

city.collectTaxes();
console.log(city.treasury);
city.applyGrowth(5);
console.log(city.population);

