function solve(array){
    const firstSum = array.reduce((acc,curr)=>acc+curr, 0);
    const modifiedArr = array.map((x,i) => x%2===0 ? x+i : x-i);
    const lastSum = modifiedArr.reduce((acc, curr) => acc+curr, 0);
    const result = [];
    result.push(firstSum, lastSum);

    console.log(modifiedArr);
    console.log(result.join('\n'));
}

solve([5, 15, 23, 56, 35])