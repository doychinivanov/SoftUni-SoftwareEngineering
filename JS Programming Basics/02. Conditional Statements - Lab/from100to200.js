function solve(arg1){
    num = Number(arg1);

    if(num<100){
        console.log("Less than 100");
    } else if (num<200) {
        console.log("Between 100 and 200");
    } else if(num>200) {
        console.log("Greater than 200");
    } else if (num=100) {
        console.log(num);
    }
}
solve("205");
solve("120");
solve("210");