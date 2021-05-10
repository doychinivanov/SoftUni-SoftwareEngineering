function solve(arg){
    let n = Number(arg);

    for(let i=0; i<=n; i+=2){
        let result = Math.pow(2,i)
        console.log(result);
    }
}

solve("4")