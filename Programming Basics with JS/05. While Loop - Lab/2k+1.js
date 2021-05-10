function solve(input){
    let i = 0;
    let n = Number(input[i]);
    let count = 1;

    while(count<=n){
        console.log(count);
        count = (2*count) + 1;
    }
}

solve(["31"])