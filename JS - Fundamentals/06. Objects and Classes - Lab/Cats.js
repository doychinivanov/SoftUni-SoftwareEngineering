function solve(arr){
    class Cat{
        constructor(cat, age){
            this.cat = cat;
            this.age = age;
        }

        meow(){
            console.log(`${this.cat}, age ${this.age} says Meow`);
        }
    }


    const catObjects = arr
    .map((line)=>line.split(' '))
    .reduce((storage, currentCat) => {
        let [cat, age] = currentCat;
        storage.push(new Cat(cat, age));

        return storage;
    }, [])

    const outPut = [];
    catObjects.forEach(x => {
        outPut.push(x.meow());
    });

    return outPut.join('\n')
}

console.log(solve(
    ['Mellow 2', 'Tom 5']
));