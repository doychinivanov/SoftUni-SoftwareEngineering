function solve (input){
    let index = 0;
    // let days = Number(input[index]);
    let allWins = 0;
    let allLoses = 0;
    let allMoney = 0;

    for(let i = 1; i<input.length; i++){
        let command = input[i];
        let victories = 0;
        let loses = 0;
        let dailycash = 0;

        while(command !== "Finish"){
            let sport = command;
            i++;
            let result = input[i];
            i++;
            command = input[i];

            if(result ==="win"){
                victories++;
                dailycash += 20;
            } else if(result === "lose"){
                loses++;
                dailycash += 0;
            }
        }

        if(victories > loses){
            dailycash *= 1.10;
        }

        allWins += victories;
        allLoses += loses;
        allMoney += dailycash;
    }

    if(allWins > allLoses){
        allMoney *= 1.20;
        console.log(`You won the tournament! Total raised money: ${allMoney.toFixed(2)}`);
    } else {
        console.log(`You lost the tournament! Total raised money: ${allMoney.toFixed(2)}`);
    }
}

solve(["2",
    "volleyball",
   "win",
    "football",
    "lose",
    "basketball",
    "win",
    "Finish",
    "golf",
    "win",
    "tennis",
    "win",
    "badminton",
    "win",
    "Finish"]
    )