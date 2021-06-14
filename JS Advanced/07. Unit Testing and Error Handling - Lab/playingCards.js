function createCard(face, suit){
    const validFaces = ['2', '3', '4', '5', '6', '7', '8', '9', '10', 'J', 'Q', 'K', 'A']
    const faceToString = {
        'S' : '\u2660',
        'H' : '\u2665',
        'D' : '\u2666',
        'C' : '\u2663',

    };

    if(validFaces.includes(face) == false){
        throw new Error('Invalid face');
    } else if(Object.keys(faceToString).includes(suit) == false){
        throw new Error('Invalid suit');
    }

    return{
        face,
        suit,
        toString(){
            return `${face}${faceToString[suit]}`;
        }
    }
}

console.log(createCard('A', 'S').toString());
console.log(createCard('10', 'H').toString());
console.log(createCard('1', 'C').toString());