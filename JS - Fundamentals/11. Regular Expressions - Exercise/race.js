function solve(array) {
    const result = [];
    const participants = array.shift().split(', ');
    const racers = participants.reduce((acc, curr) => {
        acc[curr] = 0;
        return acc
    }, []);

    let currentLine = array.shift();
    const checkName = /(?<name>[A-Za-z])/g;
    const checkScore = /(?<score>[\d])/g;

    while (currentLine !== 'end of race') {
        const match = currentLine.match(checkName);
        const name = match.join('');

        if (racers.hasOwnProperty(name)) {
            const score = currentLine.match(checkScore).map(Number).reduce((a, b) => a + b, 0);
            racers[name] += score;
        }

        currentLine = array.shift();
    }

    
    const sorted = Object.entries(racers).sort((a,b)=>b[1]-a[1]);
    result.push(`1st place: ${sorted[0][0]}`);
    result.push(`2nd place: ${sorted[1][0]}`);
    result.push(`3rd place: ${sorted[2][0]}`);

    return result.join('\n');
    
}

console.log(solve(
    [
        'George, Peter, Bill, Tom',
        'G4e@55or%6g6!68e!!@',
        'R1@!3a$y4456@',
        'B5@i@#123ll',
        'G@e54o$r6ge#',
        '7P%et^#e5346r',
        'T$o553m&6',
        'end of race'
    ]
));