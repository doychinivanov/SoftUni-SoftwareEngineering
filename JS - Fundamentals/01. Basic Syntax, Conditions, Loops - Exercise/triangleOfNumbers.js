function solve(num){
    let result = '';

    for (let i = 1; i <= num; i++) {
        for (let k = 1; k <= i; k++) {
          result += i +' ';
        }
        console.log(result);
        result = '';
    }
}

solve(5);