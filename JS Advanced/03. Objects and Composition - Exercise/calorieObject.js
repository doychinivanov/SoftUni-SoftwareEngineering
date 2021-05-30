function createObject(arr){
    const object = {};

    for (let i = 0; i < arr.length; i+=2) {
        object[arr[i]] = Number(arr[i+1]);
    }

    return object;
}

console.log(createObject(['Yoghurt', '48', 'Rise', '138', 'Apple', '52']));