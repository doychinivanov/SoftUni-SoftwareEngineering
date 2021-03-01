function solve(arr){
    arr = arr.map(Number);
    const students = arr.shift();
    const lectures = arr.shift();
    const initialBonus = arr.shift();
    let maxBonus = 0;
    let mostAttended = 0;

    for (let i = 0; i < students; i++) {
        const currentMax = arr[i] / lectures * (5 + initialBonus);

        if(maxBonus < currentMax){
            maxBonus = currentMax;
            mostAttended = arr[i];
        }
    }

    console.log(`Max Bonus: ${Math.ceil(maxBonus)}.`);
    console.log(`The student has attended ${mostAttended} lectures.`);
}

solve([
    '10', '30', '14', '8',
    '23', '27', '28', '15',
    '17', '25', '26', '5',
    '18'
  ]  
  )