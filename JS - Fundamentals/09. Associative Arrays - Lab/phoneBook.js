function createPhoneBook(array) {
    const result = [];
    const phoneBook =  array.reduce((acc, cur) => {
        let [name, number] = cur.split(' ');       
        acc[name] = number
      

        return acc;
    }, {});

    for (const key in phoneBook) {
       result.push(`${key} -> ${phoneBook[key]}`);
    }

    return result.join('\n');
}

console.log(createPhoneBook(
    ['Tim 0834212554',
        'Peter 0877547887',
        'Bill 0896543112',
        'Tim 0876566344']
));