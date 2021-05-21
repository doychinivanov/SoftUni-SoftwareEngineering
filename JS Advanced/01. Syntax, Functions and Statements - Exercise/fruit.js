function calcFruit(fruit, kilos, price){
    return `I need $${(kilos*price/1000).toFixed(2)} to buy ${(kilos / 1000).toFixed(2)} kilograms ${fruit}.`
}

console.log(calcFruit('orange', 2500, 1.80));