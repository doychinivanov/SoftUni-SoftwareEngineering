function solve(input) {
    let radi = Number(input);
    let degrees = radi * 180 / Math.PI;
    console.log(degrees.toFixed(0));
}

solve("3.1416")
solve("6.2832")

