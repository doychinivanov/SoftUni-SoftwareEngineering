function findEvenPosition(arr){
    return arr.filter((v, i) => i % 2 == 0 ? v : '').join(' ');
}

console.log(findEvenPosition(['20', '30', '40', '50', '60']));