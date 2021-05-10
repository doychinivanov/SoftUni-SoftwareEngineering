function solve(arg, arg1, arg2){
    let minutes = Number(arg);
    let walksPerDay = Number(arg1);
    let calories = Number(arg2);

    let totalMin = minutes * walksPerDay;
    let burntCal = totalMin * 5;
    
    if((calories * 1/2) <= burntCal){
        console.log(`Yes, the walk for your cat is enough. Burned calories per day: ${burntCal}.`);
    } else {
        console.log(`No, the walk for your cat is not enough. Burned calories per day: ${burntCal}.`);
    }

}
solve("30", "3", "600")