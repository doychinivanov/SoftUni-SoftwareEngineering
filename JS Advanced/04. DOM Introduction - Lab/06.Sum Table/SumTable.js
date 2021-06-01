function sumTable() {
    const data = [...document.querySelectorAll('table td')]
    .filter((x, i) => i % 2 != 0)
    .map(x => Number(x.textContent))

    document.getElementById('sum').textContent = data.reduce((ac, cur) => ac + cur, 0);
}