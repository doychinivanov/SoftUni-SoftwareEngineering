function sumInRange(array, startIndex, endIndex){
    if(Array.isArray(array) == false){
        return NaN;
    }

    if(startIndex < 0){
        startIndex = 0;
    }

    if(endIndex >= array.length){
        endIndex = array.length - 1;
    }

    return array.slice(startIndex, endIndex+1).reduce((a,c)=>a+Number(c),0);
}

console.log(sumInRange([10, 20, 30, 40, 50, 60], 3, 300));
console.log(sumInRange([10, 'twenty', 30, 40], 0, 2));
console.log(sumInRange([1.1, 2.2, 3.3, 4.4, 5.5], -3, 1));