function solve (input) {
    let i = 0;
    let currentFailures = 0;
    let sum = 0;
    let problemCount = 0;
    let maxFailures = Number(input[i]);
    i++;
    let currentProblem = input[i];
    i++;
    let currentGrade = Number(input[i]);

    while (currentProblem !== "Enough"){
        sum += currentGrade;
        problemCount++;

        if(currentGrade <= 4 ){
            currentFailures++;
        }

        if(currentFailures == maxFailures){
            console.log(`You need a break, ${currentFailures} poor grades.`);
            break;
        }

        i++;
        currentProblem = input[i];
        i++;
        currentGrade = Number(input[i]);
    }

    let avg = sum / problemCount;
    if(currentFailures !== maxFailures){
        console.log(`Average score: ${avg.toFixed(2)}`);
        console.log(`Number of problems: ${problemCount}`);
        console.log(`Last problem: ${input[i - 3]}`);
    }

}


solve(["3",
"Money",
"6",
"Story",
"4",
"Spring Time",
"5",
"Bus",
"6",
"Enough"])
