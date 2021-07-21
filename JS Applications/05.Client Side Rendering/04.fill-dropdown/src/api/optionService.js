export async function getOptions(){
    const resonse = await fetch('http://localhost:3030/jsonstore/advanced/dropdown');
    const data = await resonse.json();

    return data;
}

export async function createOption(body){
    return await fetch('http://localhost:3030/jsonstore/advanced/dropdown', {
        method: 'POST',
        ['Content-Type']: 'application/json',
        body: JSON.stringify(body)
    });
}