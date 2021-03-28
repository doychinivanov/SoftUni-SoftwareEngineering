function solve(arr){
    const actions = {
        Contains : (key, [substr])=>{
            const result = key.includes(substr) ? `${key} contains ${substr}` : 'Substring not found!'
        
            console.log(result);
            return key;
        },
        Flip : (key, [wordCase, start, end]) => {
            start = Number(start);
            end = Number(end);

            const firstPart = key.substring(0, start);
            let secondPart = key.substring(start, end);
            const tirthPart = key.substring(end);

            wordCase == 'Upper' ? secondPart = secondPart.toUpperCase() : secondPart = secondPart.toLowerCase();
            
            key = firstPart + secondPart + tirthPart;
            console.log(key);

            return key;
        },
        Slice : (key, [start, end]) =>{
            start = Number(start);
            end = Number(end);
            key = key.substring(0, start) + key.substring(end);

            console.log(key);
            return key;
        }
    }


    let key = arr.shift();

    let line = arr.shift();
    while(line !== 'Generate'){
        const [command, ...params] = line.split('>>>');
        const action = actions[command];
        key = action(key, params);

        line = arr.shift();
    }

    console.log(`Your activation key is: ${key}`);
}

solve([
    'abcdefghijklmnopqrstuvwxyz',
    'Slice>>>2>>>6',
    'Flip>>>Upper>>>3>>>14',
    'Flip>>>Lower>>>5>>>7',
    'Contains>>>def',
    'Contains>>>deF',
    'Generate'
  ])