function solve(num1, num2) {

    return (factorialize(num1) / factorialize(num2)).toFixed(2)

    function factorialize(num) {
        let result = num;
        if (num === 0 || num === 1) {
            return 1;
        } else {
            while (num > 1) {
                num--;
                result *= num;
            }
            return result;
        }
    }

}

console.log(solve(5, 2));