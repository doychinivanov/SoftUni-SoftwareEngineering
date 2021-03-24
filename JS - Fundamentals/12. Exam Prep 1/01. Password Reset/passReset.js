function solve(arr){
    const actions = {
        TakeOdd : (pass) => {
            const newPass = pass.split('')
            .filter((x,i) => i%2==0 ? '' : x)
            .join('');

            console.log(newPass);
            return newPass;
        },
        Cut : (pass, [startIndex, amount]) =>{
            startIndex = Number(startIndex);
            amount = Number(amount);

            let newPass = pass.split('');
            newPass.splice(startIndex, amount);

            console.log(newPass.join(''));
            return newPass.join('');
        },
        Substitute: (pass, [toBeReplace, replacement])=>{
            if(pass.includes(toBeReplace)){
                while(pass.includes(toBeReplace)){
                    pass = pass.replace(toBeReplace, replacement);
                }
                console.log(pass);
            } else {
                console.log('Nothing to replace!');
            }

            return pass;
        }
    }

    let pass = arr.shift();

    while((line = arr.shift()) !== 'Done'){
        const [command, ...params] = line.split(' ');
        const action = actions[command];
        pass = action(pass, params);
    }

    console.log(`Your password is: ${pass}`);
}

solve(
    [
        'up8rgoyg3r1atmlmpiunagt!-irs7!1fgulnnnqy',
        'TakeOdd',
        'Cut 18 2',
        'Substitute ! ***',
        'Substitute ? .!.',
        'Done'
      ]
)