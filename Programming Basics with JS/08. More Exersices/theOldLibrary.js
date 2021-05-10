function solve (input) {
    let desiredBook = input[0];
    let i = 1;
    let currentBook = input[i];
    let isFound = false;
    let count = 0;

    while (currentBook !== "No More Books") {
        if(currentBook === desiredBook){
            isFound = true;
            console.log(`You checked ${count} books and found it.`);
            break;
        }

        count++;
        i++;
        currentBook = input[i];
    }

    if(isFound !== true) {
        console.log(`The book you search is not here!`);
        console.log(`You checked ${count} books`);
    }
}

solve(["The Spot",
"Hunger Games",
"Harry Potter",
"Torronto",
"Spotify",
"No More Books"])
