function time(hour, min) {
    hour = Number(hour);
    min = Number(min);
    min += 15;
    hour = hour + Math.floor(min/60);
    min = min % 60;
    hour = hour % 24;

    if(min<10) {
        console.log(`${hour}:0${min}`);
    } else{
        console.log(`${hour}:${min}`);
    }
}

time("1", "46");
time("0", "01");
time("23", "59");
time("11", "08");
time("12", "49")