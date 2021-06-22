function extensibleObject() { 
    const proto = {};
    const extendedObj = Object.create(proto);

    extendedObj.extend = function(template){
        for (const key in template) {
            if(typeof template[key] == 'function'){
                const proto = Object.getPrototypeOf(this);
                proto[key] = template[key];
            } else {
                this[key] = template[key];
            }
        }
    }

    return extendedObj;
} 

const myObj = extensibleObject(); 
    
var template = {
    health: 100,
    mana: 50
};
myObj.extend(template); 
console.log(myObj.hasOwnProperty('mana'));
  