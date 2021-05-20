function doMath(a, b, operator){
    a = Number(a);
    b = Number(b);
    let result = 0;

    if(operator == '+'){
        result = a + b;
    } else if(operator == '-'){
        result = a - b;
    } else if (operator == '*'){
        result = a * b;
    } else if(operator == '/'){
        result = a / b;
    } else if (operator == '%'){
        result = a % b;
    } else if (operator == '**'){
        result = a ** b;
    }

    return result;
}

console.log(doMath(5, 6, '+'));