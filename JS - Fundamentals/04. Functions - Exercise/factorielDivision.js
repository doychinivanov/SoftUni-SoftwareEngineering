function factorielDivision (a, b) {

    function factorialize(num) {
        if (num === 0 || num === 1){
            return 1;
        } else if(num < 0) {
            return -1;
        }
        
        for (let i = num - 1; i >= 1; i--) {
          num = num * i;
        }
        return num;
      }

    let result = factorialize(a) / factorialize(b);

    return result.toFixed(2)
}

console.log(factorielDivision(7, 5));