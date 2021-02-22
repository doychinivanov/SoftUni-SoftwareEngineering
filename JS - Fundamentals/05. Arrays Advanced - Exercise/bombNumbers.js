function bombNumbers(arr, bomb) {
    let specialNumber = bomb[0];
    let range = bomb[1];

    while(arr.includes(specialNumber)){
        let index = arr.indexOf(specialNumber);
        let elementToRemove = range * 2 + 1;
        let startingPoint = index - range;

        if(startingPoint < 0){
            elementToRemove += startingPoint;
            startingPoint = 0;
        }

        arr.splice(startingPoint, elementToRemove);
    }

    return arr.reduce((a,b) => a+b, 0)
}

console.log(bombNumbers(
    [2, 4, 2, 2, 2, 9],
    [4, 2]  
));