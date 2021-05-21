function sameN(num){
    const result = [];
    let isSame = false;
    
    if(num.toString().length == 1){
        isSame = true;
    }

    for (let i = 0; i < num.toString().length - 1; i++) {

        if(num.toString()[i] == num.toString()[i+1]){
            isSame = true;
        } else {
            isSame = false;
            break;
        }
    }

    isSame ? result.push('true') : result.push('false');

    result.push(num.toString().split('').reduce((a,b) => a + Number(b),0));

    return result.join('\n');
}

console.log(sameN(22222));