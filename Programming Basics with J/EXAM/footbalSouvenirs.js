function solve(arg1, arg2, arg3){
    let team = arg1;
    let souvenir = arg2;
    let amountBought = Number(arg3);
    let priceToPay = 0;

    switch(team){
        case "Argentina":
            switch(souvenir){
                case "flags":
                    priceToPay = amountBought * 3.25; break;
                case "caps":
                    priceToPay = amountBought * 7.20; break;
                case "posters":
                    priceToPay = amountBought * 5.10; break;
                case "stickers":
                    priceToPay = amountBought * 1.25; break;
                default: console.log(`Invalid stock!`);
            } break;
        case "Brazil":
            switch(souvenir){
                case "flags":
                    priceToPay = amountBought * 4.20; break;
                case "caps":
                    priceToPay = amountBought * 8.50; break;
                case "posters":
                    priceToPay = amountBought * 5.35; break;
                case "stickers":
                    priceToPay = amountBought * 1.20; break;
                default: console.log(`Invalid stock!`);
            } break;
        case "Croatia":
            switch(souvenir){
                case "flags":
                    priceToPay = amountBought * 2.75; break;
                case "caps":
                    priceToPay = amountBought * 6.90; break;
                case "posters":
                    priceToPay = amountBought * 4.95; break;
                case "stickers":
                    priceToPay = amountBought * 1.10; break;
                default: console.log(`Invalid stock!`);
            } break;
        case "Denmark":
            switch(souvenir){
                case "flags":
                    priceToPay = amountBought * 3.10; break;
                case "caps":
                    priceToPay = amountBought * 6.50; break;
                case "posters":
                    priceToPay = amountBought * 4.80; break;
                case "stickers":
                    priceToPay = amountBought * 0.90; break;
                default: console.log(`Invalid stock!`);
            } break;
        default: console.log(`Invalid country!`);
    }

    if((team==="Argentina" || team==="Brazil" || team==="Croatia" || team==="Denmark") && (souvenir==="flags" || souvenir ==="caps" || souvenir ==="posters" || souvenir ==="stickers")){
    console.log(`Pepi bought ${amountBought} ${souvenir} of ${team} for ${priceToPay.toFixed(2)} lv.`);
    }
}

solve("USA",
    "caps",
    "18"
    )