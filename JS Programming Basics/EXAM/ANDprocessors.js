function solve(arg1, arg2, arg3){
    let target = Number(arg1);
    let workers = Number(arg2);
    let workDays = Number(arg3);

    let totalWorkHours = workers * workDays * 8;
    let processorsBulit = Math.floor(totalWorkHours / 3)

    if(processorsBulit<target){
        let losses = (target - processorsBulit) * 110.10;
        console.log(`Losses: -> ${losses.toFixed(2)} BGN`);
    } else {
        let profit = (processorsBulit - target) * 110.10;
        console.log(`Profit: -> ${profit.toFixed(2)} BGN`);
    }
}

solve("150",
    "7",
    "18"
    )