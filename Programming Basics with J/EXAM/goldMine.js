function solve(input){
    let index = 0;
    let locations = Number(input[index]);
    index++;

    for(let k = 0; k < locations; k++){
        let expectedGold = Number(input[index]);
        index++;
        let daysToWork = Number(input[index]);
        index++;
        let totalGoldPerLocation = 0;
        let averageGold = 0;
        for(let i =0; i<daysToWork; i++){
            let goldForTheDay = Number(input[index]);
            index++;
            totalGoldPerLocation += goldForTheDay;

          averageGold = totalGoldPerLocation / daysToWork;
        }
        if(averageGold>=expectedGold){
            console.log(`Good job! Average gold per day: ${averageGold.toFixed(2)}.`);
          } else {
              console.log(`You need ${(expectedGold-averageGold).toFixed(2)} gold.`);
          }
    }
}

solve([
    '1', 
    '5',
    '3',
    '10', 
    '1', 
    '3',
    // '20', 
    // '2', 
    // '20',
    // '10'
  ])