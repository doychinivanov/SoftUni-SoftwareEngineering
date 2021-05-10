function solve (flower, amount, budget) {
    amount = Number(amount);
    budget = Number(budget);
    let result = 0;

    if (flower === "Roses") {
        result =amount * 5;
        if(amount > 80) {
            result *= 0.90;
        }
    } else if (flower ==="Dahlias") {
        result = amount * 3.80;
        if (amount > 90) {
            result *= 0.85;
        }
    } else if (flower = "Tulips") {
        result = amount * 2.80;
        if(amount > 80) {
            result *= 0.85;
        }
    } else if (flower="Narcissus") {
        result = amount * 3;
        if(amount < 120) {
            result *= 1.15;
        }
    } else if (flower="Gladiolus") {
        result = amount * 2.50;
        if (amount < 80) {
            result *= 1.20;
        }
    }

    let diff = budget - result;
    if (budget >= result) {
        console.log(`Hey, you have a great garden with ${amount} ${flower} and ${diff.toFixed(2)} leva left.`);
    } else {
        console.log(`Not enough money, you need ${Math.abs(diff)} leva needed.`);
    }
}

solve("Roses", "55", "250");
solve("Tulips", "88", "260");