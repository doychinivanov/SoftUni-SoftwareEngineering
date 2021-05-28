function jsonToTable(string){
    let data = JSON.parse(string);

    return `<table>\n   <tr>${Object.keys(data[0]).map(key => `<th>${Number.isFinite(key) ? key : escapeHtml(key)}</th>`).join('')}</tr>\n${data.map(person => `   <tr>${Object.values(person).map(value => `<td>${Number.isFinite(value) ? value : escapeHtml(value)}</td>`).join('')}</tr>\n`).join('')}</table>`;


    function escapeHtml(value) {
       return value
       .replace(/&/g, '&amp;')
       .replace(/</g, '&lt;')
       .replace(/>/g, '&gt;')
       .replace(/"/g, '&quot;')
       .replace(/'/g, '&#39;');
    }

}

console.log(jsonToTable('[{"Name":"Pesho","Score":4," Grade":8},{"Name":"Gosho","Score":5,"Grade":8},{"Name":"Angel","Score":5.50," Grade":10}]'));