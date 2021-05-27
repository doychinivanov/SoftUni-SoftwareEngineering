function manipulateArr(commands){
    const result = [];
    let index = 1;

    commands.forEach(command => {

        command == "add" ? result.push(index) : result.pop();

        index++;
    });

    return result.length > 0 ? result.join('\n') : 'Empty';
}

console.log(manipulateArr(['add', 
'add', 
'remove', 
'add', 
'add']
));