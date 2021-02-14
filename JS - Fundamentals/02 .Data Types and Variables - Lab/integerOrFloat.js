function solve(a,b,c){
    sum = a + b + c;

    console.log(sum % 1 === 0 ? `${sum} - Integer` : `${sum} - Float`);
}

solve(9, 100, 1.1)