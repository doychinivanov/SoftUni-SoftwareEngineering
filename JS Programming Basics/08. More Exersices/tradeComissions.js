function solve (arg, arg2){
    let city = String(arg);
    let money = Number(arg2);
    let comission = 0;

    if(money<0 || (city!="Sofia" && city != "Plovdiv" && city!="Varna")){
        console.log("error");
    } else {
        switch (city) {
            case "Sofia":
                if(money<=500){
                    comission = money *0.05;
                } else if (money <= 1000){
                    comission = money *0.07;
                } else if(money<=10000){
                    comission = money *0.08;
                } else if(money>10000){
                    comission=money*0.12;
                } 
                console.log(comission.toFixed(2));
                break;
            case "Plovdiv":
                if(money<=500){
                    comission = money *0.055;
                } else if (money <= 1000){
                    comission = money *0.08;
                } else if(money<=10000){
                    comission = money *0.12;
                } else if(money>10000){
                    comission=money*0.145;
                } 
                console.log(comission.toFixed(2));
                break;
    
            case "Varna":
                if(money<=500){
                    comission = money *0.045;
                } else if (money <= 1000){
                    comission = money *0.075;
                } else if(money<=10000){
                    comission = money *0.1;
                } else if(money>10000){
                    comission=money*0.13;
                } 
                console.log(comission.toFixed(2));
                break;
            default: console.log("error");
        }
    }
}

solve("Plovdiv",
"-20")





