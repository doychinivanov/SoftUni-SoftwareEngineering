function sortArr(arr, type){
    const sortingActions = {
        asc(){
            return arr.sort((a,b)=>a-b);
        },
        desc(){
            return arr.sort((a,b) => b-a);
        }
    }

    return sortingActions[type]();
}

console.log(sortArr([14, 7, 17, 6, 8], 'asc'));
console.log(sortArr([14, 7, 17, 6, 8], 'desc'));