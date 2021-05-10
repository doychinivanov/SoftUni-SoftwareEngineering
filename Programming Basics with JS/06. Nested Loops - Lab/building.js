function solve(input){
    let index=0;
    let floors = Number(input[index]);
    index++;
    let rooms = Number(input[index]);

    for(let i =floors; i>=1; i--){
        let string = "";
        for(let k = 0; k<rooms; k++){
            if(i===floors){
                string += `L${i}${k}` + " ";
            } else if(i%2===0){
                string += `O${i}${k}` + " ";
            } else{
                string += `A${i}${k}` + " ";
            }
        }
        console.log(string);
    }

}

solve(["6", "4"])