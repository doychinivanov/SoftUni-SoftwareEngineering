function solve(input){
    let i = 0;
    let user = input[i];
    i++;
    let password = input[i];
    i++;
    let command = input[i];

    while(command !== password){
        command = input[i];
        i++;
    }

    console.log(`Welcome ${user}!`);

}

solve(["Gosho",
"secret",
"secret"])

