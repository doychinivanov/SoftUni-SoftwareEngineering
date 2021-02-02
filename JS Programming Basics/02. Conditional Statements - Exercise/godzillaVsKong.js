function solve(budget, count, price) {
    budget = Number(budget);
    count = Number(count);
    price = Number(price);

    let decor = budget * 0.1;
    let clothes = count * price;


    if(count > 150) {
        clothes *= 0.9;
    }

    totalCosts = decor + clothes;

    if (totalCosts > budget){
        let diff = totalCosts- budget;
        console.log("Not enough money!");
        console.log(`Wingard needs ${diff.toFixed(2)} leva more.`);
    } else {
        let diff1 = totalCosts- budget;
        let difff = Math.abs(diff1)
        console.log("Action!");
        console.log(`Wingard starts filming with ${difff.toFixed(2)} leva left.`);
    }

}

solve("20000", "120", "55.5");
solve("15437.62", "186", "57.99");
solve("9587.88", "222", "55.68");