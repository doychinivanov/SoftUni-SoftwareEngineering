function solve(array) {
    let companies = {};
    companies = setEmployees(array, companies);

    const sortedCompanies = Object
    .entries(companies)
    .sort((a,b)=> a[0].localeCompare(b[0]))
    .reduce((acc, cur) =>{
        acc.push(cur[0]);
        cur[1].forEach(employee=>{
            acc.push(`-- ${employee}`)
        })

        return acc;
    }, []);

  

    return sortedCompanies.join('\n');

    function setEmployees(arr, companies){
        arr.forEach(element => {
            let [company, employee] = element.split(' -> ');
    
            if(!companies.hasOwnProperty(company)){
                companies[company] = [];
            }
    
            companies[company].push(employee);
            let fixedEmployees = new Set(companies[company]);
            companies[company] = Array.from(fixedEmployees);
        });

        return companies;
    }
}

console.log(solve(
    [
      'SoftUni -> AA12345',
        'SoftUni -> BB12345',
        'Microsoft -> CC12345',
        'HP -> BB12345',
      'SoftUni -> AA12345',

    ]
));