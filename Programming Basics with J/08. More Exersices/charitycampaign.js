function charity(days, cooks, cakes, waffles, pancakes){
    days = Number(days);
    cooks = Number(cooks);
    cakes = Number(cakes);
    waffles = Number(waffles);
    pancakes = Number(pancakes);

    let cakeProfit = cakes * cooks * days * 45;
    let waffleProfit = waffles * cooks * days * 5.8;
    let pancakeProfit = pancakes * cooks * days * 3.2;

    let result = cakeProfit + waffleProfit + pancakeProfit;
    result -= result/8
    console.log(result);
}

charity("23", "8", "14", "30", "16");