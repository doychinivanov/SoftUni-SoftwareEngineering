function manipulateList(arr){
    const result = [];
    const actions = {
        add(element){
            result.push(element);
        },
        remove(element){
            while(result.includes(element)){
                const index = result.indexOf(element);
                result.splice(index, 1);
            }
        },
        print(){
            console.log(result.join(','));
        }
    };

    arr.forEach(line => {
        let [command, value] = line.split(' ');
        actions[command](value);
    })
}

manipulateList(['add hello', 'add again', 'remove hello', 'add again', 'print']);
manipulateList(['add pesho', 'add george', 'add peter', 'remove peter','print']);