function solve (examHour, examMinutes, arrivalHour, arrivalMinutes){
    examHour = Number(examHour);
    examMinutes = Number(examMinutes);
    arrivalHour = Number(arrivalHour);
    arrivalMinutes = Number(arrivalMinutes);


    let totalExamMinutes = ((examHour%24) * 60) + examMinutes;
    let totalArrivalMinutes = ((arrivalHour%24) * 60) + arrivalMinutes;
    let diff = totalExamMinutes - totalArrivalMinutes;
    let hours = Math.floor(Math.abs(diff) / 60);
    let minutes = Math.abs(diff) % 60;


    if(diff <0 ){
        console.log(`Late`);

        if(hours>0){
            if(minutes<10){
                minutes = `${0}:${minutes}`;
            }

            console.log(`${hours}:${minutes} hours after the start`);
        }else{
            console.log(`${minutes} minutes after the start`);
        }
    }else if(diff <=30){
        console.log(`On time`);

        if(diff !==0){
            console.log(`${minutes} minutes before the start.`);
        }
    } else{
        console.log(`Early`);
        if(hours>0){
            if(minutes<10){
                minutes = `${0}${minutes}`;
            }

            console.log(`${hours}:${minutes} hours before the start`);
        }else{
            console.log(`${minutes} minutes before the start`);
        }
    }
    
}

solve("00",
"59",
"24",
"00")







