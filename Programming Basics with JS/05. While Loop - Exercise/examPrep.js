function solve (input){
    let allowedFails = Number(input.shift());
    let fails = 0;
    let sumOfGrades = 0;
    let totalTasks = 0;

    let command = input.shift();
    let currentGrade = Number(input.shift());
    let lastTask = " ";

    while(command !== "Enough"){
        if(currentGrade<=4){
            fails++;
        }

        if(fails>=allowedFails){
            console.log(`You need a break, ${fails} poor grades.`);
            break;
        }

        sumOfGrades += currentGrade;
        totalTasks++;
        lastTask = command;


        command = input.shift();
        currentGrade = Number(input.shift());
    }

    if(fails !== allowedFails){
    console.log(`Average score: ${(sumOfGrades/totalTasks).toFixed(2)}`);
    console.log(`Number of problems: ${totalTasks}`);
    console.log(`Last problem: ${lastTask}`);
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


