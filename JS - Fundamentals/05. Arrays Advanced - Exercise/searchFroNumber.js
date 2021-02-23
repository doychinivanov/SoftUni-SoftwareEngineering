function solve(mainArr, arr) {
    let [numsToTake, numsToDelete, numToSeek] = arr;


    let result = mainArr.splice(0, numsToTake).splice(numsToDelete).filter(x => x === numToSeek);
    console.log(`Number ${numToSeek} occurs ${result.length} times.`);
}

solve([5, 2, 3, 4, 1, 6],
    [5, 2, 3]
)