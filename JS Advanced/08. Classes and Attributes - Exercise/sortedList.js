class List {
    constructor(list = []){
        this.list = list.sort((a,b) => a - b);
        this.size = this.list.length;
    }

    add(x){
        this.list.push(x);
        this.list.sort((a,b)=>a-b);
        this.size++;
    };

    remove(index){
        if(typeof index != 'number' || index < 0 || index >= this.list.length){
            throw new TypeError ('Invalid index!');
        }

        this.list.splice(index, 1);
        this.size--;
    };

    get(index){
        if(typeof index != 'number' || index < 0 || index >= this.list.length){
            throw new TypeError ('Invalid index!');
        } 

        return this.list[index];
    };
}

let list = new List();
list.add(5);
list.add(6);
list.add(7);
console.log(list.get(1)); 
list.remove(1);
console.log(list.get(1));
console.log(list.size);