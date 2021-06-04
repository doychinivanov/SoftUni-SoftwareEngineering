function generateReport() {
    const output = document.getElementById('output');
    const topics = Array.from(document.querySelectorAll('thead>tr>th'));
    const rows = Array.from(document.querySelectorAll('tbody>tr'));

    const indexes = [];
    const result = [];
    
    topics.forEach((tr, index) => tr.querySelector('input').checked == true ? indexes.push(index) : '');

    rows.forEach(row=>{
        const selectedData = {};

        indexes.forEach(index => {
            selectedData[topics[index].querySelector('input').name] = [...row.querySelectorAll('td')][index].textContent;
        });

        result.push(selectedData);
    })

    if(indexes.length > 0){
        output.value = JSON.stringify(result);
    } else {
        output.value = '';
    }
}