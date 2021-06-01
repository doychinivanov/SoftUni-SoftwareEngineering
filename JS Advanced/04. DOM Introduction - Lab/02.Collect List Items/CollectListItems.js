function extractText() {
    const data = [...document.getElementById('items').querySelectorAll('li')].map(x=>x.textContent);

    document.getElementById('result').value = data.join('\n');
}