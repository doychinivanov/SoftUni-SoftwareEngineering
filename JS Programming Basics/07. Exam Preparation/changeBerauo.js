function solve(arg, arg2, arg3){
    let bitcoins = Number(arg);
    let chineese = Number(arg2);
    let commission = Number(arg3);

    let euro = 0;
    let dollar = chineese * 0.15;
    let levas = (bitcoins*1168 + dollar*1.76 + euro*1.95)
    euro = levas / 1.95;
    commission = (euro*(commission/100));
    euro -= commission;

    console.log(euro.toFixed(2));
}

solve("20", "5678", "2.4")