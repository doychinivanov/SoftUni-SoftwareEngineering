function printDeckOfCards(cards) {
    const deck = [];
    let isValid = true;

    cards.forEach(card => {
        const data = card.split('');
        const suit = data.pop();
        const face = data.join('');

        try{
            const card = createCard(face, suit).toString();
            deck.push(card);
        } catch (err){
            isValid = false;
            console.log(`Invalid card: ${face}${suit}`);
            // throw new Error(`Invalid card: ${face}${suit}`);
        }

    });


    if(isValid){
        console.log(deck.join(' '));
    }

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
}
  
printDeckOfCards(['AS', '10D', 'KH', '2C']);
printDeckOfCards(['5S', '3D', 'QD', '1C']);