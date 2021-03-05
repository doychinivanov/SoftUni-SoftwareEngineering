function solve(array) {
    const result = [];
    const gradesObj = array.reduce((acc, cur) => {
        let [name, ...grades] = cur.split(' ');
        grades = grades.map(Number);    
        if(!acc.hasOwnProperty(name)){
            acc[name] = grades
        } else {
            acc[name] = acc[name].concat(grades);
        }

        return acc;
    }, {});
    
   Object.entries(gradesObj)
   .sort(sortGrades)
   .forEach(student => {
       result.push(`${student[0]}: ${student[1].join(', ')}`)
   });


   return result.join('\n');

    function sortGrades(a,b){
        return (a[1].reduce((ac,curr)=> ac+curr,0) / a[1].length) - (b[1].reduce((ac,curr)=> ac+curr,0) / b[1].length)
    }
}
console.log(solve(
    ['Lilly 4 6 6 5',
        'Tim 5 6',
        'Tammy 2 4 3',
        'Tim 6 6']
));