function solve(input) {

    let array = input.split(' ');
    trimInput(array);

    let sum = 0;
    for (let combination of array) {
        combination = combination.split('');
        let firstLetter = combination.shift();
        let secondLetter = combination.pop();
        let number = Number(combination.join(''));

        if (firstLetter === firstLetter.toUpperCase()) {
            number = number / (firstLetter.toLowerCase().charCodeAt() - 96)
        } else {
            number = number * (firstLetter.toLowerCase().charCodeAt() - 96)
        }

        if (secondLetter === secondLetter.toUpperCase()) {
            number = number - (secondLetter.toLowerCase().charCodeAt() - 96)
        } else {
            number = number + (secondLetter.toLowerCase().charCodeAt() - 96)
        }


        sum += number;
    }

    console.log(sum.toFixed(2));


    function trimInput(arr) {
        let fakeArr = arr.slice();

        for (let element of fakeArr) {
            if (element === '') {
                array.splice(arr.indexOf(element), 1);
            }
        }
    }

}

solve(
    'a1A'
)