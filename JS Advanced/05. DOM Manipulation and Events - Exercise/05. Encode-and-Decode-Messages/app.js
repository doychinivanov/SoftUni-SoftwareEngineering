function encodeAndDecodeMessages() {
    const buttons = Array.from(document.querySelectorAll('#main button'));
    const textareas = Array.from(document.querySelectorAll('#main textarea'))

    buttons[0].addEventListener('click', script);
    buttons[1].addEventListener('click', unscript);

    function script(){
        textareas[1].value = encode(textareas[0].value);

        textareas[0].value = '';
    }

    function unscript(){
        textareas[1].value = decode( textareas[1].value);
    }

    function encode(input){
        let encodedMsg = '';

        for (let i = 0; i < input.length; i++) {
            encodedMsg += String.fromCharCode(input.charCodeAt(i)+1);
            
        }

        return encodedMsg;
    }

    function decode(input){
        let encodedMsg = '';

        for (let i = 0; i < input.length; i++) {
            encodedMsg += String.fromCharCode(input.charCodeAt(i)-1);
            
        }

        return encodedMsg;
    }
}