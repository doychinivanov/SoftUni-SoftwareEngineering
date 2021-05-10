function solve (input) {
    i = 0;
    let name = input[i];
    i++;
    let level = 1;
    let score = 0;
    let error = 0;

    while(level <= 12){
        let grade = Number(input[i]);
        i++;
        if(grade>=4.00){
            score += grade
            level++;
        } else {
            error++;
            if(error > 1) {
                console.log(`${name} has been exculded at ${level} grade.`);
                break;
            }
        }

        if(level>12){
            let avGrade = score /12;
            console.log(`${name} graduated. Average grade: ${avGrade.toFixed(2)}`);
        }
    }
}

solve (["Mimi", 
"5",
"6",
"5",
"6",
"5",
"6",
"6",
"2",
"3"])

