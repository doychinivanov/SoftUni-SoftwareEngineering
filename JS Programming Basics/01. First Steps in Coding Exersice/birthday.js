function party (price) {
    price=Number(price);

    let cakePrice = price * 0.2;
    let drinkPrice = cakePrice - (cakePrice * 0.45);
    let animator = price / 3;

    let result = cakePrice + drinkPrice + animator + price;
    console.log(result);
}

party("2250");
party("3720");