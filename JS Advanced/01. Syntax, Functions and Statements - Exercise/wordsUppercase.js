function upperWords(input){
    const regExp = /[\W]+/g

    return input.split(regExp).filter(x=>x.length > 0).reduce((acc, curr) => {
        acc.push(curr.toUpperCase());
        return acc;
    }, []).join(', ');
}

console.log(upperWords('Functions in JS can be nested, i.e. hold other functions'));