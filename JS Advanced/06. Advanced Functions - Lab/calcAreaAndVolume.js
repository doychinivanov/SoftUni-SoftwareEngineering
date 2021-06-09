function calcAreaAndVolume(area, vol, input) {
    input = JSON.parse(input);

    const result = input.map(element => (
        {
            area: area.apply(element),
            volume: vol.apply(element)
        }
    ));

    return result;
}

const JSONarray = `[{"x":"1","y":"2","z":"10"},{"x":"7","y":"7","z":"10"},{"x":"5","y":"2","z":"10"}]`;

console.log(calcAreaAndVolume(area, vol, JSONarray));

function area() {
    return Math.abs(this.x * this.y);
};

function vol() {
    return Math.abs(this.x * this.y * this.z);
};
