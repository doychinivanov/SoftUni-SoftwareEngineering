function add(num){
    let sum = 0;
    sum += num;

    function continueAdding(newNum){
        sum += newNum;
        return continueAdding;
    }

    continueAdding.toString = () => sum;
    return continueAdding;
}

console.log(add(1).toString());
console.log(add(add(1)(6)(-3)).toString());