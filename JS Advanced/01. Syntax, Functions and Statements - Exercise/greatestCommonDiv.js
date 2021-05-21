function greatestDiv(a, b){
    if (!b) {
        return a;
      }
    
    return greatestDiv(b, a % b);

}

console.log(greatestDiv(15, 5));