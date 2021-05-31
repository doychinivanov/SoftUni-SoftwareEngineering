function operate(arr){
    const data = [];
    let thereAreOperands = true;

    arr.forEach(x => {
        if(isNaN(x)){
            if(checkIfOperationIsPosible()){
                calculate(x);
            } else {
                thereAreOperands = false;
                console.log(`Error: not enough operands!`);
            }
        } else {
            data.push(x);
        }
    });

    return setOutput();
    

    function checkIfOperationIsPosible(){
        if(data.length < 2){
            return false;
        }

        return true;
    }

    function calculate(operand){
        const a = data.pop();
        const b = data.pop();

        const operations = {
            '+':() => {
                return a + b;
            },
            '-':() => {
                return b - a;
            },
            '*':() => {
                return a * b;
            },
            '/':() => {
                return b / a;
            },
        }

        data.push(operations[operand]());
    }

    function setOutput(){
        if(thereAreOperands == false){
            return '';
        } else if(data.length == 1){
            return data[0]
        } else{
            return `Error: too many operands!`;
        }
    }
}

console.log(operate([15,
    '/']
   
   ));