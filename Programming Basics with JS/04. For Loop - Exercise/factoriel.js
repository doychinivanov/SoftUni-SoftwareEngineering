function solve(arg){
    let num = Number(arg);
    let result = 1;

    for(let i=1; i<=num; i++){
        result *= i;
    }
    console.log(result);
}

solve("5")