function solve (input) {
    i = 0;
    let width = Number(input[i]);
    i++;
    let length = Number(input[i]);
    i++;
    let highth = Number(input[i]);
    i++;

    let isFreeSpace = true;
    let cubicMetres = width * length * highth;
    let command = input[i];
    i++;

    while(command !== "Done"){
        let box = Number(command);
        cubicMetres -= box;

        if(cubicMetres<0){
            isFreeSpace = false;
            console.log(`No more free space! You need ${Math.abs(cubicMetres)} Cubic meters more.`);
            break;
        }

        command = input[i];
        i++;
    }

    if(isFreeSpace){
        console.log(`${cubicMetres} Cubic meters left.`);
    }

}

solve (["10",
"1",
"2",
"4",
"6",
"Done"])

