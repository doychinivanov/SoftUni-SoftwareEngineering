function solve(arr){
    arr.shift();
    const regex = /(@#+)([A-Z][A-Za-z\d]{4,}[A-Z])(@#+)/;
    const numberRegex = /[\d]/g;

    arr.forEach(barCode => {
        if(regex.test(barCode)){
            let number = '';
            while((match = numberRegex.exec(barCode)) !== null){
                number += match;
            }

            number == '' ? console.log(`Product group: 00`) : console.log(`Product group: ${number}`);

        } else {
            console.log('Invalid barcode');
        }
    });

}

solve(
    [ '3', '@#FreshFisH@#', '@###Brea0D@###', '@##Che46sE@##' ]
);