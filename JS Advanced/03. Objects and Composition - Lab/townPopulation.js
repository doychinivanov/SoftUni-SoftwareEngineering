function keepTrackOfPopulation(array){
    const townArchive = {};
    const result = [];

    array.forEach(line => {
        let [townName, townPopulation] = line.split(' <-> ');
        townPopulation = Number(townPopulation);

        if(townArchive.hasOwnProperty(townName)){
            townArchive[townName] += townPopulation;
        } else {
            townArchive[townName] = townPopulation;
        }
    });

    for (const key in townArchive) {
        result.push(`${key} : ${townArchive[key]}`);
    }

    return result.join('\n');
}

console.log(keepTrackOfPopulation(['Sofia <-> 1200000',
'Montana <-> 20000',
'New York <-> 10000000',
'Washington <-> 2345000',
'Las Vegas <-> 1000000']
));