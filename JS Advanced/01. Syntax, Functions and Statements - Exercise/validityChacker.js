function checkValidity(x1,y1, x2, y2){
    const result = [];
    validateEach();

    return result.join('\n');

    function calculateDistance(x1,y1, x2, y2){
        return Math.sqrt((x1-x2)**2 + (y1-y2)**2)
    }

    function validateEach(){
        if (Number.isInteger(calculateDistance(x1, y1, 0, 0))) {
            result.push(`{${x1}, ${y1}} to {0, 0} is valid`);
        } else {
            result.push(`{${x1}, ${y1}} to {0, 0} is invalid`);
        }
     
        if (Number.isInteger(calculateDistance(x2, y2, 0, 0))) {
            result.push(`{${x2}, ${y2}} to {0, 0} is valid`);
        } else {
            result.push(`{${x2}, ${y2}} to {0, 0} is invalid`);
        }
     
        if (Number.isInteger(calculateDistance(x1, y1, x2, y2))) {
            result.push(`{${x1}, ${y1}} to {${x2}, ${y2}} is valid`);
        } else {
            result.push(`{${x1}, ${y1}} to {${x2}, ${y2}} is invalid`);
        }
    }
}

console.log(checkValidity(3, 0, 0, 4));