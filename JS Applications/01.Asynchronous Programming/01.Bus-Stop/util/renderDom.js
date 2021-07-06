export function render(inputs, stopName, buses) {
    inputs.busNameInput.textContent = stopName;

    if (buses) {
        Object
            .entries(buses)
            .map(e => ({ busNubmer: e[0], time: e[1] }))
            .map(bus => {
                const li = document.createElement('li');
                li.textContent = `Bus ${bus.busNubmer} arrives in ${bus.time}`;

                return li;
            })
            .forEach(li => inputs.busesUl.appendChild(li));
    }
}