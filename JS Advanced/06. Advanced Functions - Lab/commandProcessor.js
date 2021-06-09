function solution(){
    let manipulatedString = '';

    return {
        append(someString){
            manipulatedString += someString;
        },

        removeStart(num){
            manipulatedString = manipulatedString.substring(num);
        },
        removeEnd(num){
            manipulatedString = manipulatedString.slice(0, -num);
        },
        print(){
            console.log(manipulatedString);
        }
    }
}

// let firstZeroTest = solution();

// firstZeroTest.append('hello');
// firstZeroTest.append('again');
// firstZeroTest.removeStart(3);
// firstZeroTest.removeEnd(4);
// firstZeroTest.print();

let secondZeroTest = solution();

secondZeroTest.append('123');
secondZeroTest.append('45');
secondZeroTest.removeStart(2);
secondZeroTest.removeEnd(1);
secondZeroTest.print();
