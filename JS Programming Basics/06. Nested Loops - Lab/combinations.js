function solve(input){
    let index=0;
    let N = Number(input[index]);
    let counter =0;


    for(let i=0; i<=N; i++){
        for(let k=0; k<=N; k++){
            for(let j=0; j<=N; j++){
                if(i+k+j===N){
                counter++;
                }
            }
        }
        
    }
    console.log(counter);
}

solve(["5"])