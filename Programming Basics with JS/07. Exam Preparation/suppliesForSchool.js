function solve(arg1, arg2, arg3, arg4,){
    let penAmount = Number(arg1);
    let markersAmount = Number(arg2);
    let chemLitre = Number(arg3);
    let discount = Number(arg4);

    let penPrice = 5.80 * penAmount;
    let markersPrice = 7.20 * markersAmount;
    let chemPrice = 1.20 * chemLitre;

    let total = penPrice + markersPrice + chemPrice;

    total = total - (total* (discount/100));

    console.log(total.toFixed(3));

}

solve("2",
    "3",
    "2.5",
    "25",
    )