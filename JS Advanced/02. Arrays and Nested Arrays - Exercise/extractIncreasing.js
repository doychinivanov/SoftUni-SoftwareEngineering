function extractIncreasing(arr){
    let biggest = Number.MIN_SAFE_INTEGER;

    return arr.reduce((acc, cur) => {
        if(cur >= biggest){
            biggest = cur;
            acc.push(cur);
        }

        return acc;
    }, []);

}

console.log(extractIncreasing([1, 
    3, 
    8, 
    4, 
    10, 
    12, 
    3, 
    2, 
    24]
    ));