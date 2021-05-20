function findCircleArea(r){
    return typeof r != 'number' ? `We can not calculate the circle area, because we receive a ${typeof r}.` : (Math.pow(Number(r), 2) * Math.PI).toFixed(2);
}

console.log(findCircleArea(5));