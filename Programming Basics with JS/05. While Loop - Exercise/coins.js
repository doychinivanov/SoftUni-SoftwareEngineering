function solve (input){
    let money = Number(input[0]);
    let change = (money * 100).toFixed(2);
    let coins = 0;

    while(change!==0){
        if ((change-200) >= 0){
            change-=200;
            coins++;
        }  else if ((change-100) >= 0){
            change-=100;
            coins++;
        } else if((change-50)>=0){
            change -=50;
            coins++;
        } else if ((change-20) >=0){
            change-=20;
            coins++;
        } else if ((change-10) >=0){
            change-=10;
            coins++;
        } else if ((change-5) >=0){
            change-=5;
            coins++;
        }  else if ((change-2) >=0){
            change-=2;
            coins++;
        }  else if ((change-1) >=0){
            change-=1;
            coins++;
        }
    }

    console.log(coins);
}

solve(["0.56"])