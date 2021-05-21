function cook(...params){
    const result = [];
    let num = Number(params.shift());

    const actions = {
        'chop': () => {num = num / 2},
        'dice': () => {num = Math.sqrt(num)},
        'spice': () => {num += 1},
        'bake': () => {num *= 3},
        'fillet': () => {num *= 0.8},
        
    }

    params.forEach(command => {
        actions[command]();
        result.push(num);
    });


    return result.join('\n');
}

console.log(cook('9', 'dice', 'spice', 'chop', 'bake', 'fillet'));