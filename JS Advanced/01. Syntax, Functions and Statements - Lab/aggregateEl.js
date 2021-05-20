function aggregate(arr){
    const result = [];
    let concated = '';

    concatArr();

    result.push(arr.reduce((a,b) => a+b, 0));
    result.push(arr.reduce((a,b) => a+ (1/b), 0));
    result.push(concated);

    return result.join('\n');


    function concatArr(){
        arr.map(x=> x.toString()).forEach(x => {
            concated += x;
        });
    }
}

console.log(aggregate([1, 2, 3]));