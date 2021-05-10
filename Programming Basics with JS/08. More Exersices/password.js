function solve (input){
    let index = 0;
    let user = input[index];
    index++;
    let password = input[index]
    index++;
    let currentPassword=input[index];
    index++;

    while(password !== currentPassword){
        currentPassword = input[index];
        index++;
    }

    console.log(`Welcome ${user}`);

}

solve(["Nakov",
"1234",
"Pass",
"1324",
"1234"])