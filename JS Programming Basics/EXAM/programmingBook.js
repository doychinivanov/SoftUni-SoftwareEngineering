function solve(arg1, arg2, arg3, arg4, arg5){
    let priceForOnePage = Number(arg1);
    let priceForOneSide = Number(arg2);
    let discountForPaper = Number(arg3);
    let disignerPrice = Number(arg4);
    let percentPaidFromTheCrew = Number(arg5);

    let priceForOneBook = (priceForOnePage*899) + (priceForOneSide*2);
    let totalPrice = priceForOneBook - (priceForOneBook*discountForPaper/100);
    totalPrice += disignerPrice;
    totalPrice -= totalPrice*percentPaidFromTheCrew/100;
    console.log(`Avtonom should pay ${totalPrice.toFixed(2)} BGN.`);

}

solve("0.01",
   "1",
    "10",
    "20",
    "20"
    )