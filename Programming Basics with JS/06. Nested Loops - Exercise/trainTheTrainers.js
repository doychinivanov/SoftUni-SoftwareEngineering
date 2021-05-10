function solve(input){
    let gradeCount = 0;
    let allGrades = 0;
    let juryNumber = Number(input.shift());
    let command = input.shift();
    

    while(command != "Finish"){
        let totalGrade = 0;


        for(let i = 0; i <(juryNumber); i++){
            let currentGrade = Number(input.shift());
            totalGrade += currentGrade;
            allGrades += currentGrade;
            gradeCount++;
        }
        
        let average = totalGrade / juryNumber;
        console.log(`${command} - ${average.toFixed(2)}.`);
        command = input.shift();
        
    }

    let averageForAll = (allGrades/gradeCount)
    console.log(`Student's final assessment is ${averageForAll.toFixed(2)}.`);
}

solve(["2",
"Objects and Classes",
"5.77",
"4.23",
"Dictionaries",
"4.62",
"5.02",
"RegEx",
"2.88",
"3.42",
"Finish"])


