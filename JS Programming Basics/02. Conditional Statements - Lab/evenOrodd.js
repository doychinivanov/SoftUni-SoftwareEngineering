function solve(arg1) {
    let num = Number(arg1);
    let natureofNum = num % 2;

    if (natureofNum !== 0){
        console.log("odd number");
    } else if (natureofNum == 0){
        console.log("even number");
    }
}

solve("2");
solve("3");
solve("25");
solve("1024");