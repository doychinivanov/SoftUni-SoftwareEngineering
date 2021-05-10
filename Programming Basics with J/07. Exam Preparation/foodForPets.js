function solve (input){
    let index = 0;
    let allDays = Number(input[index]);
    index++;
    let totalAmountFood = Number(input[index]);
    let dogfood = 0;
    let catFood = 0;
    let days = 0;
    let eatenFoodDay = 0;
    let biscuits = 0;
    let totalEaten = 0;
    let eatenDog = 0;
    let eatenCat = 0;
    let totalBiscuits = 0;

    for(let i = 2; i<input.length; i++){
        dogfood = Number(input[i]);
        eatenDog += dogfood;
        i++;
        catFood = Number(input[i]);
        eatenCat += catFood;
        days++;
        eatenFoodDay = dogfood + catFood;
        totalEaten += eatenFoodDay;

        if(days % 3 === 0){
            biscuits = eatenFoodDay * 0.10; 
            totalBiscuits += biscuits;
        }

    }

    console.log(`Total eaten biscuits: ${Math.round(totalBiscuits)}gr.`);
    console.log(`${((totalEaten/totalAmountFood)*100).toFixed(2)}% of the food has been eaten.`);
    console.log(`${((eatenDog/totalEaten)*100).toFixed(2)}% eaten from the dog.`);
    console.log(`${((eatenCat/totalEaten)*100).toFixed(2)}% eaten from the cat.`);

}

solve(["3",
    "500",
    "100",
    "30",
    "110",
    "25",
    "120",
    "35",
    ])