function solve (input){
    let index = 0;
    let groups = Number(input[index]);
    let currentGroup = 0;
    let allPeople = 0;
    let Musala = 0;
    let Monblanc = 0;
    let Kilim = 0;
    let K2 = 0;
    let Everest = 0;

    for(let i =1; i <=groups; i++){
        currentGroup = Number(input[i]);
        allPeople += currentGroup;

        if(currentGroup<=5){
            Musala += currentGroup;
        } else if(currentGroup<=12){
            Monblanc += currentGroup;
        } else if (currentGroup<=25){
            Kilim += currentGroup;
        } else if(currentGroup<=40){
            K2 += currentGroup;
        } else if (currentGroup>=41){
            Everest += currentGroup;
        }
    }

    console.log(`${((Musala/allPeople)*100).toFixed(2)}%`);
    console.log(`${((Monblanc/allPeople)*100).toFixed(2)}%`);
    console.log(`${((Kilim/allPeople)*100).toFixed(2)}%`);
    console.log(`${((K2/allPeople)*100).toFixed(2)}%`);
    console.log(`${((Everest/allPeople)*100).toFixed(2)}%`);  
}

solve(["10",
    "10",
    "5",
    "1",
    "100",
    "12",
    "26",
    "17",
    "37",
    "40",
    "78"
    ])