function convert(name, lastName, hairColor){
    const obj = {name, lastName, hairColor};

    console.log(JSON.stringify(obj));
}

convert('George',
'Jones',
'Brown'
)