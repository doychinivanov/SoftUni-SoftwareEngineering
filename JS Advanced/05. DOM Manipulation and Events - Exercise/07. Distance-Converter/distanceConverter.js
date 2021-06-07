function attachEventsListeners(){
    document.getElementById('convert').addEventListener('click', ()=>{
        const initialValue = Number(document.getElementById('inputDistance').value);
        const chosenUnit = Array.from(document.querySelectorAll('#inputUnits>option')).filter(x => x.selected)[0].value;
        const targetUnit = Array.from(document.querySelectorAll('#outputUnits>option')).filter(x => x.selected)[0].value;
       
        const valueInMetres = convertToMetres(initialValue, chosenUnit);    
        document.getElementById('outputDistance').value = fromMetresToRest(valueInMetres, targetUnit);
    });


    function convertToMetres(value, type){
        const relations = {
            'km': value * 1000,
            'm': value,
            'cm': value / 100,
            'mm': value / 1000,
            'mi': value * 1609.34,
            'yrd': value * 0.9144,
            'ft': value * 0.3048,
            'in': value * 0.0254,
        };

        return relations[type];
    }

    function fromMetresToRest(value, type){
        const relations = {
            'km': value / 1000,
            'm': value,
            'cm': value / 0.01,
            'mm': value / 0.001,
            'mi': value / 1609.34,
            'yrd': value / 0.9144,
            'ft': value / 0.3048,
            'in': value / 0.0254,
        }

        return relations[type];
    }

}