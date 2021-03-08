function solve(array) {
    const destinations = {};

    array.forEach(element => {
        let [country, town, cost] = element.split(' > ');

        if (!destinations.hasOwnProperty(country)) {
            destinations[country] = {};
        }

        if (!destinations[country].hasOwnProperty(town)) {
            destinations[country][town] = Number(cost);
        }

        destinations[country][town] = Math.min(destinations[country][town], Number(cost));
    });

    let orderedCountries = Object.keys(destinations).sort((a,b)=>a.localeCompare(b));
    let result = '';

    for (let country of orderedCountries) {
        result += country + ' -> ';
        let sortedPrices = Object.keys(destinations[country])
        .sort((a,b)=>travelCost(a, b, destinations, country));

        for (let town of sortedPrices) {
            result += `${town} -> ${destinations[country][town]} `;
        }
        result += '\n'
    }

    return result;

    function travelCost(town1, town2, destination, country){
        let priceOne = destination[country][town1];
        let priceTwo = destination[country][town2];

        return priceOne - priceTwo;
    }
}

console.log(solve(
    [
        'Bulgaria > Sofia > 25000',
        'Bulgaria > Sofia > 25000',
        'Kalimdor > Orgrimar > 25000',
        'Albania > Tirana > 25000',
        'Bulgaria > Aarna > 25010',
        'Bulgaria > Lukovit > 10'
    ]
));