function convert(data){
    const result = [];
    data = JSON.parse(data);
    
    for (const key in data) {
        result.push(`${key}: ${data[key]}\n`)
    }

    return result.join('')
}

console.log(convert(
    '{"name": "George", "age": 40, "town": "Sofia"}'
));