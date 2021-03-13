function solve(text){
    const firstHalf = text.substring(0, text.length/2).split('').reverse().join('');
    const secondHalf = text.substring(text.length/2, text.length).split('').reverse().join('');

    return `${firstHalf}\n${secondHalf}`;
}

console.log(solve('tluciffiDsIsihTgnizamAoSsIsihT'));