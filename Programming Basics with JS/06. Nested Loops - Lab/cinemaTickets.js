function solve(input){
    let index = 0;
    let title = input[index];
    index++;
    let allSeats = Number(input[index]);
    index++;
    let biletType = input[index];
    index++;
    let countStudents = 0;
    let countStandart = 0;
    let countKid = 0;
    let boughtBillets = 0;
 
    while(title !== "Finish"){
        let bilets = 0;
 
            while(biletType !== "End"){
            if(biletType === "student"){
                countStudents++;
            }else if(biletType === "standard"){
                countStandart++;
            }else if(biletType === "kid"){
                countKid++;
            }
            boughtBillets++;
            bilets++;
            if(bilets >= allSeats){
                break;
            }
            biletType = input[index];
            index++;
 
 
        }
        console.log(`${title} - ${(bilets / allSeats * 100).toFixed(2)}% full.`);
 
        title = input[index];
        index++;
        allSeats = Number(input[index]);
        index++;
        biletType = input[index];
        index++;
    }
        console.log(`Total tickets: ${boughtBillets}`);
        console.log(`${(countStudents / boughtBillets * 100).toFixed(2)}% student tickets.`);
        console.log(`${(countStandart / boughtBillets * 100).toFixed(2)}% standard tickets.`);
        console.log(`${(countKid / boughtBillets * 100).toFixed(2)}% kids tickets.`);
}

solve(["The Matrix",
"20",
"student",
"standard",
"kid",
"kid",
"student",
"student",
"standard",
"student",
"End",
"The Green Mile",
"17",
"student",
"standard",
"standard",
"student",
"standard",
"student",
"End",
"Amadeus",
"3",
"standard",
"standard",
"standard",
"Finish"])

