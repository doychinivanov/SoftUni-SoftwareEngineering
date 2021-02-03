function solve (month, nights) {
    nights = Number(nights);
    let priceStudio = 0;
    let priceApartment = 0;

    if(month === "May" || month === "October") {
        priceStudio = 50 * nights;
        priceApartment = 65 * nights;
        if(nights > 7 && nights < 14){
            priceStudio *= 0.95;
            console.log(`Apartment: ${priceApartment.toFixed(2)} lv`);
            console.log(`Studio: ${priceStudio.toFixed(2)} lv`);
        } else if (nights > 14){
            priceStudio *=  0.70;
            priceApartment *= 0.90; 
            console.log(`Apartment: ${priceApartment.toFixed(2)} lv`);
            console.log(`Studio: ${priceStudio.toFixed(2)} lv`);
        } 
    } else if(month === "June" || month === "September"){
        priceStudio = 75.20 * nights;
        priceApartment = 68.70 * nights;
        if (nights > 14){
            priceStudio *=  0.80;
            priceApartment *= 0.90;
            console.log(`Apartment: ${priceApartment.toFixed(2)} lv`);
            console.log(`Studio: ${priceStudio.toFixed(2)} lv`); 
        } else {     
            console.log(`Apartment: ${priceApartment.toFixed(2)} lv`);
            console.log(`Studio: ${priceStudio.toFixed(2)} lv`); 
        }
    } else if (month==="July" || month==="August"){
        priceStudio = 76*nights;
        priceApartment = 77 * nights;
        if (nights > 14){
            priceApartment *= 0.90; 
            console.log(`Apartment: ${priceApartment.toFixed(2)} lv`);
            console.log(`Studio: ${priceStudio.toFixed(2)} lv`);
        } else {     
            console.log(`Apartment: ${priceApartment.toFixed(2)} lv`);
            console.log(`Studio: ${priceStudio.toFixed(2)} lv`); 
        }
    }
}



solve ("July", "13")