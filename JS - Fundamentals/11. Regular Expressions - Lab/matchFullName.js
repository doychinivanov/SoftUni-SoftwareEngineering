function solve([text]) {
    let pattern = /\b[A-Z][a-z]+ [A-Z][a-z]+\b/g;

    const matches = text.match(pattern);
    return matches.join(' ')
}

console.log(solve('Ivan Ivanov, Ivan ivanov, ivan Ivanov, IVan Ivanov, Test Testov, Ivan	Ivanov'));