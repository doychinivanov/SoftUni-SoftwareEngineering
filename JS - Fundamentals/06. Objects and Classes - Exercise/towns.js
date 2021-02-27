function solve(arr) {
    arr
    .map(line => line.split(' | '))
    .forEach(element => {
        let [town, latitude, longtitude] = element;
        console.log({
            town, 
            latitude : Number(latitude).toFixed(2), 
            longitude : Number(longtitude).toFixed(2)
        });
    });  
}

solve(
    ['Sofia | 42.696552 | 23.32601',
    'Beijing | 39.913818 | 116.363625']
);