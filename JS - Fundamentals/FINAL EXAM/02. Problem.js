function solve(arr){
    arr.shift();
    const pattern = /!(?<command>[A-Z][a-z]{2,})!:\[(?<message>[A-Za-z]{8,})\]/;

    arr.forEach(message => {
        const encrypted = [];
        if(pattern.test(message)){
            const match = pattern.exec(message);
            const command = match.groups.command;
            const msg = match.groups.message;

            encrypted.push(`${command}:`)

            for (let i = 0; i < msg.length; i++) {
                encrypted.push(`${msg[i].charCodeAt()}`);
            }

        console.log(encrypted.join(' '));
        } else {
            console.log('The message is invalid');
        }
    })
}

solve(["3",
"go:[outside]",
"!drive!:YourCarToACarWash",
"!Watch!:[LordofTheRings]"])

