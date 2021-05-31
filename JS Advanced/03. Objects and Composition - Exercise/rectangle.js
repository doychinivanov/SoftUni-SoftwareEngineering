function rectangle(width, height, color){
    return {
        width: Number(width),
        height: Number(height),
        color: capitalize(color),
        calcArea: function(){
            return this.height * this.width;
        }
    }

    function capitalize(word) {
        return word[0].toUpperCase() + word.slice(1);
    }
}

let rect = rectangle(4, 5, 'red');
console.log(rect.width);
console.log(rect.height);
console.log(rect.color);
console.log(rect.calcArea());
