function reading(pages, speed, days) {
    pages = Number(pages);
    speed = Number(speed);
    days = Number(days);

    let neededTime = pages / speed / days;
    console.log(neededTime);

}

reading("212", "20", "2");
reading("432", "15", "4");