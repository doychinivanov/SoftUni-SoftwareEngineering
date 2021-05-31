function convertToJSON(arr){
    let [columns, ...data] = arr.map(splitLine);

    return JSON.stringify(data.map(entry =>{
        return columns.reduce((acc, cur, i) => {
            acc[cur] = entry[i];

            return acc;
        }, {})
    }))


    function splitLine(line){
        return line.split('|').filter(x => x != '').map(x => x.trim()).map(convertIfNum);
    }

    function convertIfNum(x){
        return isNaN(x) ? x : Number(Number(x).toFixed(2))
    }

}

console.log(convertToJSON(['| Town | Latitude | Longitude |',
'| Veliko Turnovo | 42.696552 | 23.32601 |',
'| Beijing | 39.913818 | 116.363625 |']
));