function returnDay(day){
    const week = {
        'Monday' : 1,
        'Tuesday' : 2,
        'Wednesday' : 3,
        'Thursday' : 4,
        'Friday' : 5,
        'Saturday' : 6,
        'Sunday' : 7
    }

    return week[day] ? week[day] : 'error';
}

console.log(returnDay('Monday'));