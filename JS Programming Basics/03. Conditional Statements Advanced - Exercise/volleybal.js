function solve (arg, arg2, arg3){
    let yearType = String(arg);
    let holydays = Number(arg2);
    let weekendsHome = Number(arg3);
    let totalWeeks = 48;
    let sofiaWeeks = totalWeeks - weekendsHome;
    let homeGames = weekendsHome;
    let sofiaGames= 0;
    let gamesTotal = 0;

    sofiaGames = sofiaWeeks * 3/4;
    gamesTotal = holydays * 2/3;
    gamesTotal += sofiaGames + homeGames;
    
    if(yearType === "leap"){
        gamesTotal *= 1.15;
    }

    console.log(Math.floor(gamesTotal));

}

solve("normal",
"6",
"13")






