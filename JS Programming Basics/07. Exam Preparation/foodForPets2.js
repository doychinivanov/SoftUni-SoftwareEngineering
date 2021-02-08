function solve (input){
    let index = 0;
    let allDays = Number(input[index]);
    index++;
    let totalFood = Number(input[index]);
    let currentDay = 0;
    let totalBiscuits = 0;
    let eatenDog = 0;
    let eatenCat = 0;
    let eatenFood = 0;
    let dailyConsumption = 0;

    for(let i = 2; i<input.length; i++){
        let biscuits = 0;
        let dogFood = Number(input[i]);
        i++;
        let catFood = Number(input[i]);
        currentDay++;
        dailyConsumption = dogFood + catFood;

        
        if(currentDay % 3==0){
            biscuits = (dogFood + catFood) * 0.10;
            totalBiscuits += biscuits
        }

        eatenFood += dailyConsumption;
        eatenDog += dogFood;
        eatenCat += catFood;
    }

    console.log(`Total eaten biscuits: ${Math.round(totalBiscuits)}gr.`);
    console.log(`${((eatenFood/totalFood)*100).toFixed(2)}% of the food has been eaten.`);
    console.log(`${((eatenDog/eatenFood)*100).toFixed(2)}% eaten from the dog.`);
    console.log(`${((eatenCat/eatenFood)*100).toFixed(2)}% eaten from the cat.`);
}

solve(["3",
    "1000",
    "300",
    "20",
    "100",
    "30",
    "110",
    "40",
    ])