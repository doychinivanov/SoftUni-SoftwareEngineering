function solve (input){
    let width = Number(input.shift());
    let length = Number(input.shift());

    let cakeCapacisty = width*length;
    let piecesTaken = 0;
    let command = input.shift();

    while(command !=="STOP"){
        piecesTaken+= Number(command);

        if(piecesTaken > cakeCapacisty){
            break;
        }

        command = input.shift();
    }

    if(piecesTaken>cakeCapacisty){
        console.log(`No more cake left! You need ${piecesTaken - cakeCapacisty} pieces more.`);
    } else{
        console.log(`${cakeCapacisty-piecesTaken} pieces are left.`);
    }

}

solve(["10",
"2",
"2",
"4",
"6",
"STOP"])
;
