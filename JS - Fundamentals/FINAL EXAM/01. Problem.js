function solve(arr){
    const actions = {
        Case : (username, [stringCase]) => {
            username = stringCase === 'upper' ? username.toUpperCase() : username.toLowerCase();
            console.log(username);
            return username;
        },
        Reverse : (username, [startIndex, endIndex]) => {
            startIndex = Number(startIndex);
            endIndex = Number(endIndex);

            if(startIndex>=0 && endIndex < username.length){
                console.log(username.substring(startIndex, endIndex+1).split('').reverse().join(''));
            }

            return username;
        },
        Cut : (username, [subst]) =>{
            if(username.includes(subst)){
                const pattern = new RegExp(`${subst}`, 'g');

                while(username.includes(subst)){
                    username = username.replace(pattern, '')
                }
                console.log(username);

            } else {
                console.log(`The word ${username} doesn\'t contain ${subst}.`);
            }

            return username;
        },
        Replace: (username, [char]) =>{
            if(username.includes(char)){
                const pattern = new RegExp(`${char}`, 'g');

                while(username.includes(char)){
                    username = username.replace(pattern, '*')
                }

                console.log(username);
            }

            return username;
        },
        Check : (username, [char]) =>{
            if(username.includes(char)){
                console.log('Valid');
            } else {
                console.log(`Your username must contain ${char}.`);
            }

            return username;
        }
    }


    let initialUser = arr.shift();
    while((line = arr.shift()) !== 'Sign up'){
        const [command, ...params] = line.split(' ');
        const action = actions[command];
        initialUser = action(initialUser, params);
    }
}

solve(["ThisIsMyString", 
"Reverse 1 4", 
"Replace i", 
"Cut My", 
"Sign up"]) 

