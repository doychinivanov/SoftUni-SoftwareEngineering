function sortNums(arr){
    const length = arr.length;

    
    return arr
    .sort((a,b) => b - a)
    .reduce((acc,curr,i) => {
        if(acc.length < length){
            acc.push(arr[arr.length - 1 - i]);
        }

        if(acc.length < length){
            acc.push(arr[i]);
        }

        return acc;
    }, []);

}

console.log(sortNums([7, 5, 8, 11, 9, 11, 5]));