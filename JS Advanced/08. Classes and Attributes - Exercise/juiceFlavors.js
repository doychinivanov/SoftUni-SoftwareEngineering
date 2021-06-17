function makeBottles(arr){
    const bottles = {};
    const juiceStorage = arr
    .map(line=>line.split(' => '))
    .reduce((acc, cur) => {
        const fruitType = cur[0];
        const litres = Number(cur[1]);

        if(acc.hasOwnProperty(fruitType) == false){
            acc[fruitType] = 0;
        }

        acc[fruitType] += litres;
        fillBottleIfPossible(fruitType, acc);

        return acc;
    },{});

    return Object.entries(bottles)
    .map(([juiceType, bottles])=>`${juiceType} => ${bottles}`)
    .join('\n');

    function fillBottleIfPossible(fruit, storage){
        let isEnoughForABottle = false;

        while(storage[fruit] - 1000 >= 0){
            isEnoughForABottle = true;
            storage[fruit] -= 1000;

            if(isEnoughForABottle){
                if(bottles.hasOwnProperty(fruit) == false){
                    bottles[fruit] = 0;
                };
    
                bottles[fruit] += 1;
            }
        };
    }
};

console.log(makeBottles(
['Orange => 2000',
'Peach => 1432',
'Banana => 450',
'Peach => 600',
'Strawberry => 549']
));

console.log('-----------------------');

console.log(makeBottles(
    ['Kiwi => 234',
    'Pear => 2345',
    'Watermelon => 3456',
    'Kiwi => 4567',
    'Pear => 5678',
    'Watermelon => 6789']    
));