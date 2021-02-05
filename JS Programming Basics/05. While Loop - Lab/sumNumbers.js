function solve(input){
    let i = 0;
    let relativeNumber= Number(input[i]);
    i++;
    let command = Number(input[i]);
    let sum = 0;

    while(sum < relativeNumber){
        sum += command;
        i++;
        command=Number(input[i]);
    }

    console.log(sum);
}

solve(["20",
"1",
"2",
"3",
"4",
"5",
"6"])



