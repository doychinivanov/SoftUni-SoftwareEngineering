function solve(arg, arg2){
    let month = String(arg);
    let nights = Number(arg2);
    let studioPrice = 0;
    let apartmentPrice=0;
    let studioTotal =0;
    let apartmentTotal = 0;

    if(month === "May" || month==="October"){
        studioPrice = 50;
        apartmentPrice = 65;
        studioTotal = nights * studioPrice;
        apartmentTotal = nights * apartmentPrice;
        if(nights>7 && nights<14){
            studioTotal *= 0.95;
        } else if(nights>14){
            studioTotal *= 0.7;
            apartmentTotal *= 0.9;
        }
    } else if(month === "June" || month === "September"){
        studioPrice = 75.2;
        apartmentPrice = 68.7;
        studioTotal = nights * studioPrice;
        apartmentTotal = nights * apartmentPrice;
        if(nights>14){
            studioTotal *= 0.8;
            apartmentTotal*= 0.9;
        }
    } else if(month === "July" || month === "August"){
        studioPrice = 76;
        apartmentPrice = 77;
        studioTotal = nights * studioPrice;
        apartmentTotal = nights * apartmentPrice;
        if(nights>14){
            apartmentTotal *= 0.9;
        }
    }

    console.log(`Apartment: ${apartmentTotal.toFixed(2)} lv.`);
    console.log(`Studio: ${studioTotal.toFixed(2)} lv.`);
}

solve("August",
"20")


