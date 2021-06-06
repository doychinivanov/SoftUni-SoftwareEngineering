function attachGradientEvents() {
    const gradient = document.querySelector('#gradient-box>#gradient');
    const resultField = document.getElementById('result');

    gradient.addEventListener('mousemove', (ev)=>{
        const percent = Math.trunc(ev.offsetX / ev.target.clientWidth * 100);
        
        resultField.textContent = `${percent}%`
    });
}