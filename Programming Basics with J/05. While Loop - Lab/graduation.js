function solve(input){
    let i =0;
    let name = input[i];
    i++;
    let sum = 0;
    let level = 1;
    let fails = 0;

    while(level<=12){
        let grade = Number(input[i]);
        i++;
        if(grade>=4.00){
            sum+=grade;
            level++;
        } else{
            fails++;
            if(fails>1){
                console.log(`${name} has been excluded at ${level} grade`);
                break;
            }
        }


        if(level>12){
            let average = sum / 12;
            console.log(`${name} graduated. Average grade: ${average.toFixed(2)}`);
        }
    }
}

solve(["Gosho", 
"5",
"5.5",
"6",
"5.43",
"5.5",
"6",
"5.55",
"5",
"6",
"6",
"5.43",
"5"])


