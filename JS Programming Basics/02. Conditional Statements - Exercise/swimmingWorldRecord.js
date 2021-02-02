function solve(record, distance, timeForMin) {
    record = Number(record);
    distance = Number(distance);
    timeForMin = Number(timeForMin);

    let ivansTime = distance * timeForMin;
    let slow = Math.floor(distance / 15) * 12.5
    ivansTime = ivansTime + slow;

    if(ivansTime < record) {
        console.log(`Yes, he succeeded! The new world record is ${ivansTime.toFixed(2)} seconds.`);
    } else {
        let diff = ivansTime - record;
        console.log(`No, he failed! He was ${diff.toFixed(2)} seconds slower.`);
    }


}

solve("10464", "1500", "20");
solve("55555.67", "3017", "5.03");

