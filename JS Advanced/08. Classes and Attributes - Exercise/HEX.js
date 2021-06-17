class Hex {
    constructor(value){
        this.value = Number(value);
    }

    valueOf(){
        return this.value;
    };

    toString(){
        return '0x' + this.value.toString(16).toUpperCase();
    };

    plus(x){
        if(x instanceof Hex){
            return new Hex(this.value + x.value);
        } else if(typeof x == 'number'){
            return new Hex(this.value + x);
        }

        return new Hex(this.value);
    };

    minus(x){
        if(x instanceof Hex){
            return new Hex(this.value - x.value);
        } else if(typeof x == 'number'){
            return new Hex(this.value + x);
        }
    };

    parse(string){
        return parseInt(string.slice(2), 16);
    }
}

let FF = new Hex(255);
console.log(FF.toString());
console.log(FF.valueOf() + 1 == 256);
let a = new Hex(10);
let b = new Hex(5);
console.log(a.plus(b).toString());
console.log(a.plus(b).toString()==='0xF');
console.log(FF.parse('0xF'));