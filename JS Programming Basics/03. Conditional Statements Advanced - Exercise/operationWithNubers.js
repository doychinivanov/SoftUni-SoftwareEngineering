function solve (N1, N2, operator) {
    N1 = Number(N1);
    N2 = Number(N2);
    let result = 0;
    let evenOrOdd = "odd";

    if (operator === "+") {
        result = N1 + N2;
        if(result % 2 === 0) {
            evenOrOdd = "even"
        }
        console.log(`${N1} ${operator} ${N2} = ${result} - ${evenOrOdd}`);
    } else if (operator === "-"){
        result = N1 - N2;
        if(result % 2 === 0) {
            evenOrOdd = "even"
        } 
        console.log(`${N1} ${operator} ${N2} = ${result} - ${evenOrOdd}`);
    } else if (operator ==="*") {
        result = N1 * N2;
        if(result % 2 === 0) {
            evenOrOdd = "even"
        } 
        console.log(`${N1} ${operator} ${N2} = ${result} - ${evenOrOdd}`);
    
    } else if (operator === "/"){
        if(N2 == 0){
            console.log(`Cannot divide ${N1} by zero.`);
        } else{
        result = (N1/N2);
        (result % 2 === 0)
            evenOrOdd = "even"
            console.log(`${N1} / ${N2} = ${result.toFixed(2)}`);
        }
    } else if (operator = "%"){
        if(N2==0) {
            console.log(`Cannot divide ${N1} by zero.`);
        } else {
            result = N1 % N2;
            console.log(`${N1} % ${N2} = ${result}`);
        }
       
    } 
}

solve("10", "12", "+");
solve("10", "1", "-");
solve("7", "3", "*");
solve("123", "12", "/");
solve("10", "3", "%");
solve("112", "0", "/");
solve("10", "0", "%");
