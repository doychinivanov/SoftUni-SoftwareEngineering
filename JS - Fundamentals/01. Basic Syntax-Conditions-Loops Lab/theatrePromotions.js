function solve(day, age) {
    let prices = {
        'Weekday': [12, 18, 12],
        'Weekend': [15, 20, 15],
        'Holiday': [5, 12, 10],
    }

    let price = prices[day];
    if (age >= 0 && age <= 18) {
        console.log(`${price[0]}$`);
    } else if (age > 18 && age <= 64) {
        console.log(`${price[1]}$`);
    } else if (age > 64 && age <= 122) {
        console.log(`${price[2]}$`);
    } else {
        console.log(`Error!`);
    }
}

solve('Holiday', 67)