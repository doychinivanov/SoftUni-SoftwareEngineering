function solve(arr) {
    let result = [];
    const actions = {
        Chat: (chatHolder, [message]) => {
            chatHolder.push(message);
            return chatHolder;
        },
        Delete: (chatHolder, [message]) => {
            if(chatHolder.find(x => x=== message)){
                chatHolder.splice(chatHolder.indexOf(message),1);
            }
            return chatHolder;
        },
        Edit: (chatHolder, [oldMessage, newMessage]) => {
            if(chatHolder.find(x => x=== oldMessage)){
                let indexToChange = chatHolder.indexOf(oldMessage);
                chatHolder[indexToChange] = newMessage;
            }

            return chatHolder;
        },
        Pin: (chatHolder, [message]) => {
            if(chatHolder.find(x => x=== message)){
                chatHolder.splice(chatHolder.indexOf(message),1);
                chatHolder.push(message);
            }

            return chatHolder;
        },
        Spam: (chatHolder, params) => {
            params.forEach(x => chatHolder.push(x));
            return chatHolder;
        },
    }

    arr.forEach(line => {
        let [command, ...params] = line.split(' ');

        if(command !== 'end'){
            result = actions[command](result, params);
        }
        
    });

    return result.join('\n');

}

console.log(solve(
    (["Chat John",
    "Spam Let's go to the zoo",
    "Edit zoo cinema",
    "Chat tonight",
    "Pin John",
    "end"])   

));