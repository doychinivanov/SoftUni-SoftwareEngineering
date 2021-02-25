function createObj(firstName, lastName, age) {
    return {
        firstName,
        lastName,
        age : Number(age)
    }
}

console.log(createObj(
    "Peter",
    "Pan",
    "20"
));