function solve(sourceAmount) {
    let days = 0;
    let collected = 0;

    while (sourceAmount >= 100) {
        collected += sourceAmount;
        sourceAmount -= 10;
        if (collected >= 26) {
            collected -= 26;
        }
        days++;
    }

    if (collected >= 26) {
        collected -= 26;
    }


    console.log(days);
    console.log(collected);
}

solve(111)