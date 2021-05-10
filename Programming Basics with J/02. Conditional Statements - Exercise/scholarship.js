function solve(arg1,arg2,arg3){
    let money = Number(arg1);
    let grade = Number(arg2);
    let minSalary = Number(arg3);
    let scholarship = 0;
    let scholarship2 = 0;
    let boolean = true;
    let boolean2 = true;

    if(money<minSalary && grade>4.5){
        scholarship = minSalary * 0.35;
    } else {
        boolean = false;
    }


    if(grade>=5.5){
        scholarship2 = grade * 25;
    } else{
        boolean2=false;
    }

    if(boolean===false && boolean2===false){
        console.log(`You cannot get a scholarship!`);
    } else if(scholarship>scholarship2){
        console.log(`You get a Social scholarship ${Math.floor(scholarship)} BGN`);
    } else if (scholarship<=scholarship2){
        console.log(`You get a scholarship for excellent results ${Math.floor(scholarship2)} BGN`);
    }
}

solve("300.00",
"5.65",
"420.00")
