function solve(arg1, arg2){
    let numA = Number(arg1);
    let numB = Number(arg2);
    let result = 0;

    for(let i=numA; i<=numB; i++){
        if(i%9===0){
            result +=i;
        }
    }
    console.log(`The sum: ${result}`);

    for(let z = numA; z<= numB; z++){
        if(z %9 ===0){
            console.log(z);
        }
    }
}

solve("100", "200")