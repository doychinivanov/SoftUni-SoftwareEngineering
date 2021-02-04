function solve (input){
    let n = Number(input[0]);
    p1=0;
    p2=0;
    p3=0;

    for(let i=1; i<input.length; i++){
        let currentNum = Number(input[i]);

        if(currentNum % 2===0 && currentNum%3===0 && currentNum%4===0){
            p1++;
            p2++;
            p3++;
        } else if(currentNum%2===0 && currentNum%4===0){
            p1++;
            p3++;
        } else if(currentNum%2===0 && currentNum%3===0){
            p1++;
            p2++;
        } else if(currentNum%2===0){
            p1++;
        } else if(currentNum%3===0){
            p2++
        } else if(currentNum%4===0){
            p3++
        }
    }
    console.log(`${((p1/n*100).toFixed(2))}%`);
    console.log(`${((p2/n*100).toFixed(2))}%`);
    console.log(`${((p3/n*100).toFixed(2))}%`);
}

solve(["3",
"3",
"6",
"9"])

