function solve(text){
    text = text.split('\\');
    const file = text[text.length-1].split('.');
    const extention = file.splice(file.length-1, 1);
    const fileName = file.join('.');

    return `File name: ${fileName}\nFile extension: ${extention}`;
}

console.log(solve('C:\\Internal\\training-internal\\Template.pptx'));