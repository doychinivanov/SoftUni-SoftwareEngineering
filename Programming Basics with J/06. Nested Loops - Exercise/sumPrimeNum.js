function solve(input) {
    let currentNum = input.shift();
    let primeSum = 0;
    let nonPrimeSum = 0;
    while (currentNum !== "stop") {
        currentNum = Number(currentNum);
        if (currentNum < 0) {
            console.log(`Number is negative.`);
            currentNum = input.shift();
            continue;
        }
        let isPrime = true;
        for (let i = 2, s = Math.sqrt(currentNum); i <= s; i++) {
            if (currentNum % i === 0) {
                isPrime = false;
                break;
            }
        }
        if (isPrime) {
            primeSum += currentNum;
        } else {
            nonPrimeSum += currentNum;
        }
        currentNum = input.shift();
    }
    console.log(`Sum of all prime numbers is: ${primeSum}`);
    console.log(`Sum of all non prime numbers is: ${nonPrimeSum}`);
 
}
solve(["30",
"83",
"33",
"-1",
"20",
"stop"])
