function solve(array) {
    const colors = {
        'S': 4,
        'H': 3,
        'D': 2,
        'C': 1
    };

    const types = {
        'J': 11,
        'Q': 12,
        'K': 13,
        'A': 14
    };

    const players = {};
    const result = [];

    array.forEach(element => {
        let [name, hand] = element.split(': ');
        hand = hand.split(', ');

        if (!players.hasOwnProperty(name)) {
            players[name] = [];
        }

        players[name].push(...hand);
    });

    for (const key in players) {
        let cards = new Set(players[key]);
        let total = 0;

        Array.from(cards).forEach(card => {
            let element = card.split('');
            let cardColor = element.pop();
            let value = element.join('');

            if (isNaN(value)) {
                value = types[value];
            }

            total += colors[cardColor] * Number(value);
        });

        result.push(`${key}: ${total}`);
    }

    return result.join('\n');
}

console.log(solve(
    [
        'Peter: 2C, 4H, 9H, AS, QS',
        'Tomas: 3H, 10S, JC, KD, 5S, 10S',
        'Andrea: QH, QC, QS, QD',
        'Tomas: 6H, 7S, KC, KD, 5S, 10C',
        'Andrea: QH, QC, JS, JD, JC',
        'Peter: JD, JD, JD, JD, JD, JD'
    ]
));