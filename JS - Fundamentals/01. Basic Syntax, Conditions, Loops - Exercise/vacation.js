function solve(people, packet, day){
    let packets = {
        'Students': { 
            'Friday': 8.45,
            'Saturday': 9.80,
            'Sunday' : 10.46
        },
        'Business': {
            'Friday': 10.90,
            'Saturday': 15.60,
            'Sunday' : 16
        },
        'Regular': {
            'Friday': 15,
            'Saturday': 20,
            'Sunday' : 22.50
        }
    }

    let priceForOne = packets[packet][day];
    let totalPrice = priceForOne * people;
    
    if(packet === 'Students' && people>=30){
        totalPrice *= 0.85;
    } else if(packet === 'Business' && people>=100){
        totalPrice = priceForOne * (people - 10);
    } else if (packet === 'Regular' && (people>=10 && people <=20)){
        totalPrice *= 0.95;
    }

    console.log(`Total price: ${totalPrice.toFixed(2)}`);
}

solve(30,
    "Students",
    "Sunday"
    )