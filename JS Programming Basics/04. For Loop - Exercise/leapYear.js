function solve(arg, arg2){
    let firstYear = Number(arg);
    let secondYear = Number(arg2);

    for(let i=firstYear; i<=secondYear; i++){
        if(i%4===0){
            console.log(i);
        }
    }

}

solve("2020",
"2032")


