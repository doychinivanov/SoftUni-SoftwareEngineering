function attachEventsListeners() {
    document.querySelector('main').addEventListener('click', calculateTime);

    function calculateTime(ev){
        if(ev.target.id == 'daysBtn' || ev.target.id == 'hoursBtn' || ev.target.id == 'minutesBtn' || ev.target.id == 'secondsBtn'){
           const type = ev.target.previousElementSibling.id;
           const value = ev.target.previousElementSibling.value;
          
           const timeData = convertTime(type, value);

           document.getElementById('days').value = timeData.days;
            document.getElementById('hours').value = timeData.hours;
            document.getElementById('minutes').value = timeData.minutes;
            document.getElementById('seconds').value = timeData.seconds;;
        }
    }

    function convertTime(type, value){
        value = Number(value);
        let time = {
            'days' : {
                days : value,
                hours : value * 24,
                minutes : value * 1440,
                seconds : value * 86400,
            },
            'hours' : {
                days : value / 24,
                hours : value,
                minutes : value * 60,
                seconds : value * 3600,
            },
            'minutes' : {
                days : value / 1440,
                hours : value / 60,
                minutes : value,
                seconds : value * 60,
            },
            'seconds' : {
                days : value / 86400,
                hours : value / 3600,
                minutes : value / 60,
                seconds : value,
            }
        }

        return time[type];
    }
}