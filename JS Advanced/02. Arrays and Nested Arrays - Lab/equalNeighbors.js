function findNeighbors(arr){
    let pairs = 0;

    for (let i = 0; i < arr.length; i++) {
        for (let j = 0; j < arr[i].length; j++) {
            if(i < arr.length-1){
                if(arr[i][j] === arr[i+1][j]){
                    pairs++;
                }
            }

            if(j < arr[i].length-1){
                if(arr[i][j] === arr[i][j+1]){
                    pairs++;
                }
            }
        }
    }

    return pairs;
}

const array = [['2', '2', '5', '7' ,'4'],
['4', '0', '5', '3' ,'4'],
['2', '5', '5', '4' ,'3']];

console.log(findNeighbors(array));