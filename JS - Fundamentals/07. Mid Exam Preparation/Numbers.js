function solve(str){
    const result =  str.split(' ')
    .map(Number)
    .filter(x => x > (str.split(' ').map(Number).reduce((acc, cur) => acc+cur, 0)/str.split(' ').length))
    .sort((a,b) => b - a)
    .slice(0, 5)
    .join(' ') 

    return result ? result : 'No'
}

console.log(solve(
    '5 2 3 4 -10 30 40 50 20 50 60 60 51'
));