function extract(id) {
    const regex = /\((.+?)\)/gm;
    const result = [];
    const element = document.getElementById(id);

    let match = regex.exec(element.textContent);

    while(match != null){
        result.push(match[1]);

        match = regex.exec(element.textContent);
    }

    return result.join('; ')
}