function solve(country){
    let languages = {
        'USA': `English`,
        'England': `English`,
        'Spain': `Spanish`,
        'Argentina': `Spanish`,
        'Mexico': `Spanish`,
    }

    if(languages.hasOwnProperty(country) === false){
        console.log(`unknown`);
    } else {
        console.log(languages[country]);
    }
}

solve(`USA`)