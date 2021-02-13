function solve(array){
    let password = array.shift();
    let countFails = 0;
    let isBlocked = false;
    
    for (let i = 0; i < array.length; i++) {
        let probablePass = array[i].split('').reverse().join('');
        if(password === probablePass){
            console.log(`User ${password} logged in.`);
        } else {
            countFails++;
            if(countFails===4){
                isBlocked = true;
                break;
            }
            console.log(`Incorrect password. Try again.`);
        }
    }

    if(isBlocked){
        console.log(`User ${password} blocked!`);
    }
}

solve(
    ['sunny','rainy','cloudy','sunny','not sunny']
)