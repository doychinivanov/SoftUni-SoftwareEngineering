function keepTrackOfProduction(arr){
    const carStorage = arr
    .map(line=>line.split(' | '))
    .reduce((acc, cur) => {
        const brand = cur[0];
        const model = cur[1];
        const amountProduced = Number(cur[2]);

        if(acc.hasOwnProperty(brand) == false){
            acc[brand] = {};
        }

        if(acc[brand].hasOwnProperty(model) == false){
            acc[brand][model] = 0;
        }

        acc[brand][model] += amountProduced;

        return acc;
    },{});

    return Object
    .entries(carStorage)
    .map(([brandName, modelData]) => `${brandName}\n${Object
        .entries(modelData)
        .map(currentModel => `###${currentModel[0]} -> ${currentModel[1]}`)
        .join('\n')}`)
    .join('\n');    
}

console.log(keepTrackOfProduction(
['Audi | Q7 | 1000',
'Audi | Q6 | 100',
'BMW | X5 | 1000',
'BMW | X6 | 100',
'Citroen | C4 | 123',
'Volga | GAZ-24 | 1000000',
'Lada | Niva | 1000000',
'Lada | Jigula | 1000000',
'Citroen | C4 | 22',
'Citroen | C5 | 10']
));