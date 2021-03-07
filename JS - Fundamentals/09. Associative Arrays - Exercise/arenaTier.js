function solve(array) {
    const gladiators = array.reduce((acc, cur) => {
        if (cur.includes('->')) {
            let [name, ability, hp] = cur.split(' -> ');
            hp = Number(hp);

            if (!acc.hasOwnProperty(name)) {
                acc[name] = {};
            }

            if (acc[name].hasOwnProperty(ability)) {
                hp = Math.max(acc[name][ability], hp);
            }

            acc[name][ability] = hp;

        };

        if (cur.includes('vs')) {
            let [gladiator1, gladiator2] = cur.split(' vs ');
            if (acc.hasOwnProperty(gladiator1) && acc.hasOwnProperty(gladiator2)) {
                const commonItem = commonKeys(acc[gladiator1], acc[gladiator2]);

                if (commonItem.length > 0) {
                    let gladiator1Skills = calculateSkills(acc[gladiator1]);
                    let gladiator2Skills = calculateSkills(acc[gladiator2]);

                    gladiator1Skills > gladiator2Skills ? delete acc[gladiator2] : delete acc[gladiator1]
                }
            }
        }

        return acc;
    }, {});

    return Object
    .entries(gladiators)
    .sort(sortGladiators)
    .reduce((result, cur) => {
        result.push(`${cur[0]}: ${calculateSkills(cur[1])} skill`);

        Object.entries(cur[1]).sort((a,b)=> b[1] - a[1] || a[0].localeCompare(b[0])).forEach(element => {
            result.push(`- ${element[0]} <!> ${element[1]}`)
        });
        
        return result;
    },[])
    .join('\n');


    function commonKeys(obj1, obj2) {
        let keys = [];
        for (let key in obj1) {
            if (obj2.hasOwnProperty(key)) {
                keys.push(key);
            }
        }
        return keys;
    }

    function sortGladiators(a,b){
        return  calculateSkills(b[1]) - calculateSkills(a[1]) || a[0].localeCompare(b[0]);
    }

    function calculateSkills(gladiator){
        return Object.entries(gladiator).reduce((acc,cur)=> acc +cur[1], 0);
    }
}

console.log(solve(
    [
        'Pesho -> Duck -> 400',
        'Julius -> Shield -> 150',
        'Gladius -> Heal -> 200',
        'Gladius -> Support -> 250',
        'Gladius -> Shield -> 250',
        'Peter vs Gladius',
        'Gladius vs Julius',
        'Gladius vs Maximilian',
        'Ave Cesar',
    ]
));