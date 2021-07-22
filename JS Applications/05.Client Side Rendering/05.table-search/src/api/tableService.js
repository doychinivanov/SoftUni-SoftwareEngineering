export async function getTableData(){
    const resonse = await fetch('http://localhost:3030/jsonstore/advanced/table');
    const data = await resonse.json();

    return data;
}