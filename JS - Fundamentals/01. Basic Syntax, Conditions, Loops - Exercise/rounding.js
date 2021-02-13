function solve(number, round){
    if(round > 15){
        round = 15;
    }

    number = number.toFixed(round);
    number = parseFloat(number);

    console.log(number);
}

solve(
    10.5, 3
)