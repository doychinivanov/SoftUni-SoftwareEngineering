function solve(arg) {
    let num = Number(arg);
    let bonus = 0;

    if(num<=100){
        bonus+=5
    } else if(num>1000){
        bonus = num*0.1
    } else if (num>100){
        bonus = num*0.2;
    }

    if(num%2===0){
        bonus++
    }

    if(num%10===5){
        bonus+=2
    }

    console.log(bonus);
    console.log(num+bonus);
}

solve("15875")


