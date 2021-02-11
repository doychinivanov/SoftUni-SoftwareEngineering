function solve(input){
    let index = 0;
    let N = Number(input[index]);
    index++;
    let M = Number(input[index]);
    index++;
    let S = Number(input[index]);
    let string = "";

    for(let i = M; i>=N; i--){
        if((i%2===0) && (i%3===0)){
            if(i===S){
                break;
            }
            string += i + " ";
        }
    }

    console.log(string);
}

// solve([ '1', '30', '15' ])
solve([ '1', '36', '12' ])
// solve([ '20', '1000', '36' ])