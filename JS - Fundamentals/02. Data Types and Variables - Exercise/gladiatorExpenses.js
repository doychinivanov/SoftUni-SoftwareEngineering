function solve(loses, helmet, sword, shield, armor) {
    let result = 0;
    let brokenShield = 0;

    for (let i = 1; i <= loses; i++) {
        if (i % 2 === 0) {
            result += helmet;
        }

        if (i % 3 === 0) {
            result += sword;
        }

        if (i % 2 === 0 && i % 3 === 0) {
            result += shield;
            brokenShield++;
        }

        if (brokenShield % 2 === 0 && brokenShield > 0) {
            result += armor;
            brokenShield = 0;
        }
    }
    console.log(`Gladiator expenses: ${result.toFixed(2)} aureus`);
}

solve(23,
    12.50,
    21.50,
    40,
    200
)