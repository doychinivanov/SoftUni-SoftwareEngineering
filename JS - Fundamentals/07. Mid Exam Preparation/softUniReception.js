function solve(arr){
    const answersPerHour = arr.slice(0, 3)
    .map(Number)
    .reduce((arr, cur) => arr+cur, 0);
    
    let questions = Number(arr[arr.length-1]);
    let neededHours = 0;

    const manPower = {
        answersPerHour,
        questions,
        neededHours
    }

    function calculateTime(obj){
        while(this.questions > 0){
            this.questions -= this.answersPerHour;
            this.neededHours++;
    
            if(this.neededHours % 4 === 0){
                this.neededHours++;
            }
        }

        return `Time needed: ${this.neededHours}h.`
    }
    
    return calculateTime.call(manPower)
}

console.log(solve(
    ['1','2','3','45']
));