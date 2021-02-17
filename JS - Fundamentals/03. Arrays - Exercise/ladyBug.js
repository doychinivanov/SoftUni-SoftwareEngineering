function ladyBug (array){
    let fieldSize = array[0];
    let initialPosition = array[1];
    initialPosition = initialPosition.split(" ");
    let commands = array.slice(2);
    let field = [];
    let free = 0;
    let occupied = 1;

    for (let i = 0; i < fieldSize; i++) {
        field.push(free);        
    }

    for (let i = 0; i < initialPosition.length; i++) {
        let position = Number(initialPosition[i]);

        if(position > field.length-1){
            continue;
        }

        field[position] = occupied;
    }

    for (let i = 0; i < commands.length; i++) {
        let currentCommand = commands[i];
        currentCommand = currentCommand.split(" ");

        let position = Number(currentCommand[0]);
        let direction = currentCommand[1];
        let flyCount = Number(currentCommand[2]);

        if(field[position] === free || position < 0 || position > field.length-1){
            continue;
        }

        field[position] = free;

        if(flyCount < 0){
            direction = direction === "right" ? "left" : "right";
            flyCount = Math.abs(flyCount);
        }

        let newPosition = 0;

        if(direction === "right"){
            newPosition = position + flyCount;
        } else if(direction === "left"){
            newPosition = position - flyCount;
        }

        while(field[newPosition] === occupied){
            if(direction==="right"){
                newPosition += flyCount;
            } else if(direction === "left"){
                newPosition -= flyCount;
            }
        }

        if(newPosition > field.length-1 || newPosition < 0){
            continue;
        }

        field[newPosition] = occupied;
        
    }

    console.log(field.join(" "));
}

ladyBug([ 3, '0 1',
'0 right 1',
'2 right 1' ]
)