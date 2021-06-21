class Person{
    constructor(firstName, lastName){
        this._firstName = firstName;
        this._lastName = lastName;
        this._fulName;
    }

    set firstName(newName){
        this._firstName = newName;
    }

    set lastName(newName){
        this._lastName = newName;
    }

    set fullName(newFullName){
        newFullName = newFullName.split(' ');
        this._firstName = newFullName[0];
        this._lastName = newFullName[1];
    }

    get firstName(){
        return this._firstName;
    }

    get lastName(){
        return this._lastName;
    }

    get fullName(){
        return `${this._firstName} ${this._lastName}`;
    }
}

let person = new Person("Peter", "Ivanov");
console.log(person.fullName); //Peter Ivanov
person.firstName = "George";
console.log(person.fullName); //George Ivanov
person.lastName = "Peterson";
console.log(person.fullName); //George Peterson
person.fullName = "Nikola Tesla";
console.log(person.firstName); //Nikola
console.log(person.lastName); //Tesla
