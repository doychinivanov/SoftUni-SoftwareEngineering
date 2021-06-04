function solve() {
    const selectElement = document.querySelector('#selectMenuTo');
    createOptions();
    
    const options = Array.from(document.querySelectorAll('#selectMenuTo>option'))
    const input = document.getElementById('input');
    const output = document.getElementById('result')

    document.querySelector('button').addEventListener('click', ()=>{
        const chosen = options.filter(x => x.selected)[0].value
        const result = convertDecimal(Number(input.value), chosen);
        
        output.value = result;
    });


    function convertDecimal(number, toType){
        const actions = {
            binary: ()=>{
                return number.toString(2)
            },
            hexadecimal: ()=>{
                return number.toString(16).toUpperCase();
            }
        }

        return actions[toType]();
    }

    function createOptions(){
        const binaryOption = document.createElement('option');
        const hexadecimalOption = document.createElement('option');
        binaryOption.value = 'binary';
        binaryOption.text = 'Binary';
        hexadecimalOption.value = 'hexadecimal';
        hexadecimalOption.text = 'Hexadecimal';
        selectElement.add(binaryOption);
        selectElement.add(hexadecimalOption);
    }
}