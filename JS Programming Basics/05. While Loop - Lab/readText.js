function solve(input){
    let i = 0;
    let command = input[i]

    while( command != "Stop"){
        console.log(command);
        i++;
        command = input[i]
    }
}

solve(["Sofia",
"Berlin",
"Moscow",
"Athens",
"Madrid",
"London",
"Paris",
"Stop",
"AfterStop"])

