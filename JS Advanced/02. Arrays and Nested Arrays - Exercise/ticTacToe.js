function playTicTac(arr){
    const field = createField();
    const result = [];
    let currentPlayer = 'X';

    for (let i = 0; i < arr.length; i++) {
        let [row, column] = arr[i].split(' ').map(Number);
        
        if(field[row][column] == 'false'){
            if(currentPlayer == 'X'){
                field[row][column] = 'X';
                currentPlayer = 'O';
            } else if(currentPlayer == 'O') {
                field[row][column] = 'O';
                currentPlayer = 'X';
            }
        } else {
            result.push('This place is already taken. Please choose another!');
        }


        const data = checkForWinner();
        if(data.everyFieldIsTaken || data.thereIsWinner){
            break;
        }
    }

    result.push(field.map(row => row.join('\t')).join('\n'));

    return result.join('\n')

    function createField(){
        const field = [];

        for (let i = 0; i < 3; i++) {
            const row = [];
            for (let j = 0; j < 3; j++) {
                row.push('false');
            }

            field.push(row);
        }

        return field;
    }

    function checkForWinner(){
        let thereIsWinner = false;
        let winner = '';
        let everyFieldIsTaken;

        const rowResult = checkRow(thereIsWinner, winner);
        const columnResult = checkColumn(thereIsWinner, winner);
        const diagonalResult = checkDiagonals(thereIsWinner, winner);

        winner = rowResult.winner || columnResult.winner || diagonalResult.winner;
        thereIsWinner = rowResult.thereIsWinner || columnResult.thereIsWinner || diagonalResult.thereIsWinner;

        everyFieldIsTaken = searchForWinner(thereIsWinner, winner, everyFieldIsTaken);

        return {thereIsWinner, everyFieldIsTaken};
    }


    function checkRow(thereIsWinner, winner){
        for (let j = 0; j < field.length; j++) {
            if(field[j].includes('false') == false && field[j].every(v => v == field[j][0])){
                winner = field[j][0];
                thereIsWinner = true;
                break;
            }
        }

        return {thereIsWinner, winner};
    }


    function checkColumn(thereIsWinner, winner){
        for (let k = 0; k < 3; k++) {
            const currentColumn = [];

            currentColumn.push(field[0][k]);
            currentColumn.push(field[1][k]);
            currentColumn.push(field[2][k]);

            if(currentColumn.includes('false') == false){
                if(currentColumn.every(v => v == currentColumn[0])){
                    thereIsWinner = true;
                    winner = currentColumn[0];
                    break;
                }
            }
        }

        return {thereIsWinner, winner}
    }

    function checkDiagonals(thereIsWinner, winner){
        const leftDiagonal = [];
        const rigthDiagonal = [];

        // Diagonal
        for (let i = 0; i < field.length; i++) {
            leftDiagonal.push(field[i][i]);
            rigthDiagonal.push(field[i][field.length - 1 -i]);
        }

        if(leftDiagonal.includes('false') == false || rigthDiagonal.includes('false') == false){
            if(leftDiagonal.every(v => v == leftDiagonal[0])){
                thereIsWinner = true;
                winner = leftDiagonal[0];
            }

            if(rigthDiagonal.every(v => v == rigthDiagonal[0])){
                thereIsWinner = true;
                winner = rigthDiagonal[0];
            }
        }

        return {thereIsWinner, winner};
    }

    function searchForWinner(thereIsWinner, winner, everyFieldIsTaken){
        if(thereIsWinner){
            result.push(`Player ${winner} wins!`);
        } else if(thereIsWinner == false) {
            everyFieldIsTaken = field[0].every(v => v != 'false') && field[1].every(v => v != 'false') && field[2].every(v => v != 'false');
        
            if(everyFieldIsTaken){
                result.push('The game ended! Nobody wins :(');
            }
        }

        return everyFieldIsTaken;
    }
}

console.log(playTicTac(["0 1",
"0 0",
"0 2",
"2 0",
"1 0",
"1 2",
"1 1",
"2 1",
"2 2",
"0 0"]
));