function solve(arg1, arg2, arg3){
    let worldRecord = Number(arg1);
    let distance = Number(arg2);
    let timeForOneSec = Number(arg3);

    let GeorgiTime = distance * timeForOneSec;
    let slow = Math.floor((distance/50)) * 30;
    GeorgiTime += slow;

    if(GeorgiTime<worldRecord){
        console.log(`Yes! The new record is ${GeorgiTime.toFixed(2)} seconds.`);
    } else{
        console.log(`No! He was ${(GeorgiTime - worldRecord).toFixed(2)} seconds slower.`);
    }
}

solve("5554.36",
    "1340",
    "3.23"
    )