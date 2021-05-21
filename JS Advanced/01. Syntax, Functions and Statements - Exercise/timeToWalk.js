function calcTime(steps, footLength, speed){
    const time = (steps * footLength) / (speed / 3.6);
    const min = Math.floor(time/60);
    const sec = Math.round(time - (min *60));
    const hours = Math.floor(time / 3600);
    const restTime = Math.floor((steps*footLength) / 500);

    return `${(hours < 10 ? "0" + hours : hours)}:${(min + restTime < 10 ? "0" + (min + restTime) : min + restTime)}:${(sec < 10 ? "0" + sec : sec)}`
}

console.log(calcTime(2564, 0.70, 5.5));