function solve(day){
    let weekDays = [`Monday`, 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday'];

    if(day<=0 || day>weekDays.length){
        console.log(`Invalid day!`);
    } else {
        console.log(weekDays[day-1])
    }
}
solve();