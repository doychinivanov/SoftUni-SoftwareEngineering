function solve(arr){
    let numbers = arr.shift().split(' ').map(Number);
    
    const actions = {
        Shoot : ([index, power], arr) => {
            [index, power] = convertToNum(index, power);
            
            if(checkIndex(index, arr)){
                arr[index] - power > 0 ? arr[index] -= power : arr.splice(index, 1);
            }

            return arr;
        },

        Add : ([index, target], arr) => {
            [index, target] = convertToNum(index, target);

            if(checkIndex(index, arr)){
                arr.splice(index, 0, target);
            } else {
                console.log('Invalid placement!');
            }

            return arr;
        }, 

        Strike : ([index, blast], arr) =>{
            [index, blast] = convertToNum(index, blast);

            if(checkIndex(index, arr) && validBlast(index, blast, arr)){
                arr.splice(index-blast, blast * 2 + 1);
            } else {
                console.log('Strike missed!');
            }

            return arr;
        }
    }

    // arr.forEach(line => {
    //     const [command, ...params] = line.split(' ');
    //     if(command != 'End'){
    //         numbers = actions[command](params, numbers);    
    //     } else {
    //         return;
    //     }
    // });

    for (let i = 0; i < arr.length; i++) {
        const [command, ...params] = arr[i].split(' ');
        if(command != 'End'){
            numbers = actions[command](params, numbers);    
        } else {
            break;
        }
    }


    return numbers.join('|');

    function checkIndex(i, arr){
        const isValid = i >= 0 && i < arr.length ? true : false;

        return isValid;
    }

    function convertToNum(a, b){
        a = Number(a),
        b = Number(b);

        return [a,b];
    }

    function validBlast(i, blast, arr){
        let obliterate;

        if(blast * 2 + 1 < arr.length && i - blast >= 0 && i + blast < arr.length){
            obliterate = true;
            //  :)
        } else {
            obliterate = false;
            //  :(
        }

        return obliterate;
    }

}


console.log(solve([
    '52 74 23 44 96 110',
    'Shoot 5 10',
    'Shoot 1 80',
    'Strike 0 1',
    'Add 22 3',
    'End',
    'Add 22 3'
  ]));