function strLength(...args){
    const result = [];
    let totalLength = 0;

    args.forEach(word => totalLength += word.length);
    result.push(totalLength);
    result.push(Math.floor(totalLength / args.length));

    return result.join('\n');
}

console.log(strLength('chocolate', 'ice cream', 'cake'));