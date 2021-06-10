function calculator() {
    let firstNum;
    let secondNum;
    let result;

    const operations = {
        init(selector1, selector2, resultHolder){
            firstNum = document.querySelector(selector1);
            secondNum = document.querySelector(selector2);
            result = document.querySelector(resultHolder);
        },
        add(){
            result.value = Number(firstNum.value) + Number(secondNum.value);
        },
        subtract(){
            result.value = Number(firstNum.value) - Number(secondNum.value);
        }
    }

    return operations;
}

const calculate = calculator (); 
calculate.init ('#num1', '#num2', '#result'); 