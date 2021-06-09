function filterEmplyees(JSONdata, criteria){
    let result = [];
    const data = JSON.parse(JSONdata);

    if(criteria == 'all'){
        result = data.map(styleOutput);
    } else {
        let [key, value] = criteria.split('-');
        const filteredEmplyees = data.filter(person => person[key] == value);

        result = filteredEmplyees.map(styleOutput);
    }

    function styleOutput(personObject, index){
        return `${index}. ${personObject.first_name} ${personObject.last_name} - ${personObject.email}`
    }

    return result.join('\n');
}

const emplyeesJSON = `[{
    "id": "1",
    "first_name": "Ardine",
    "last_name": "Bassam",
    "email": "abassam0@cnn.com",
    "gender": "Female"
  }, {
    "id": "2",
    "first_name": "Kizzee",
    "last_name": "Jost",
    "email": "kjost1@forbes.com",
    "gender": "Female"
  },  
{
    "id": "3",
    "first_name": "Evanne",
    "last_name": "Maldin",
    "email": "emaldin2@hostgator.com",
    "gender": "Male"
  }]`;

  const criteria = 'gender-Female';

console.log(filterEmplyees(emplyeesJSON, criteria));