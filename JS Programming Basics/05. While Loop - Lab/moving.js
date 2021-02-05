function solve (input) {
    let i=0;
    let width = Number(input[i]);
    i++;
    let length = Number(input[i]);
    i++;
    let heigth = Number(input[i]);
    i++;
    let command = input[i];
    let space = width * length * heigth;
    let boxSpace = 0;
    let box = 0;

    while(command !== "Done"){
        box = Number(command);
        boxSpace += box;

        if(space < boxSpace){
            let diff = boxSpace - space;
            console.log(`No more free space! You need ${diff} Cubic meters more.`);
            break;
        }

        i++;
        command=input[i]
    }

    if(space>=boxSpace){
        let diff2 = space - boxSpace;
        console.log(`${diff2} Cubic meters left.`);
    }
}

solve(["10",
"1",
"2",
"4",
"6",
"Done"])

