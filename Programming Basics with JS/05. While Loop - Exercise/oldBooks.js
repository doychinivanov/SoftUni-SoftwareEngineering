function solve(input){
    let i = 0;
    let wantedBook = input[i];
    i++;
    let checkedBooks = 0;
    let currentBook = input[i];

    while(currentBook!=="No More Books"){
        if(currentBook === wantedBook){
            console.log(`You checked ${checkedBooks} books and found it.`);
            break;
        } else{
            checkedBooks++;
            i++;
            currentBook=input[i];
        }
    }

    if(currentBook!==wantedBook){
        console.log(`The book you search is not here!`);
        console.log(`You checked ${checkedBooks} books.`);
    }
}

solve(["Bourne",
"True Story",
"Forever",
"More Space",
"The Girl",
"Spaceship",
"Strongest",
"Profit",
"Tripple",
"Stella",
"The Matrix",
"Bourne"])


