function createSortedList(){
    const list = [];

    function add(element){
        list.push(element);
        this.size++;

        return list.sort((a,b) => a - b);
    }

    function remove(index){
        if(checkIndex(index)){
            list.splice(index, 1);
            this.size--;
        }
    }

    function get(index){
        if(checkIndex(index)){
            return list[index];
        }
    }

    function checkIndex(index){
        if(index >= 0 && index < list.length){
            return true;
        }

        return false;
    }

    return {
        add,
        remove,
        get,
        size: 0
    };
}


let list = createSortedList();
list.add(5);
list.add(6);
list.add(7);
console.log(list.get(1)); 
list.remove(1);
console.log(list.size);
console.log(list.get(1));
