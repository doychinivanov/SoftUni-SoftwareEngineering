function solve (arg, arg2){
    let age = Number(arg);
    let sex = String(arg2);

    if(sex==="m" && (age>=16)){
        console.log("Mr.");
    } else if(sex==="m" && (age<16)){
        console.log("Master");
    } else if(sex==="f" && (age>=16)){
        console.log("Ms.");
    } else if(sex==="f" && (age<16)){
        console.log("Miss");
    }

}

solve("17",
"m")
