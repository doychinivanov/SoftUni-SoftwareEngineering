function solve(input){
    let index = 0;
    let foodKg = Number(input[index]);
    let foodGr = foodKg * 1000;
    index++;
    let command = input[index];

    while(command !== "Adopted"){
        let eatenFood = Number(command);
        foodGr -= eatenFood;
        index++;
        command = input[index]
    }

    if(foodGr>=0){
        console.log(`Food is enough! Leftovers: ${foodGr} grams.`);
    } else {
        console.log(`Food is not enough. You need ${Math.abs(foodGr)} grams more.`);
    }
}

solve(["3",
    "1000",
    "1000",
    "1000",
    "Adopted"
])