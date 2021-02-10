function solve(input){
    let amountOfTabs = Number(input[0]);
    let salary = Number(input[1]);

    for(let i=2; i<input.length; i++){
        let tab = input[i];

        if(tab==="Facebook"){
            salary-=150;
        } else if(tab==="Instagram"){
            salary-=100;
        } else if(tab==="Reddit"){
            salary-=50;
        }
    }
    if(salary<=0){
        console.log(`You have lost your salary.`);
    } else {
        console.log(salary);
    }
}

solve(["3",
"500",
"Facebook",
"Stackoverflow.com",
"softuni.bg"])


