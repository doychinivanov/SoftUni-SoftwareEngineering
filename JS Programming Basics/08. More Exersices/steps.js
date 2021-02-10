function solve (input) {
    const goal = 10000;
    let steps = 0;
    let i =0;

    while(steps < goal) {
        let current = input[i];
        if(current == "Going home"){
            steps += Number(input[input.length-1]);
            break;
        }

        current = Number(current);
        steps+= current;
        i++;
    }

    if(steps>=goal){
        console.log(`Goal reached! Good job`);
        console.log(`${steps - goal} steps over the goal.`);
    } else {
        console.log(`${goal - steps} more steps to reach goal.`);
    }
}

solve(["125",
"250",
"4000",
"30",
"2678",
"4682"])



