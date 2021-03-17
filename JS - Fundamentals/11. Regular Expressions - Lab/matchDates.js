function solve([input]){
    const result = [];
    const pattern = /\b(?<day>[\d]{2})(?<separator>[\/\-\.])(?<month>[A-Z]{1}[a-z]{2})\k<separator>(?<year>[\d]{4})\b/g

    while((validDate = pattern.exec(input)) !== null){
        const day = validDate.groups.day;
        const month = validDate.groups.month;
        const year = validDate.groups.year;

        result.push(`Day: ${day}, Month: ${month}, Year: ${year}`);
    }

    return result.join('\n');
}

console.log(solve([
    '13/Jul/1928, 10-Nov-1934, 01/Jan-1951, 25.Dec.1937, 23/09/1973, 1/Feb/2016'
  ]));