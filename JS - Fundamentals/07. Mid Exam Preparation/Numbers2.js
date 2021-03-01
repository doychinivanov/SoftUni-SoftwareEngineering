function solve(str){
    const arrayOutput =  str.split(' ').map(Number);
    const average = arrayOutput.reduce((acc, cur) => acc+cur, 0)/arrayOutput.length;

    const result =  arrayOutput.filter(x => x>average).sort((a,b) => b - a).slice(0, 5).join(' ');

    return result ? result : 'No'
}

console.log(solve(
    '5 2 3 4 -10 30 40 50 20 50 60 60 51'
));