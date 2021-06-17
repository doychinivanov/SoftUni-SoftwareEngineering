class Company {
    constructor(){
        this.departments = {};
    }

    addEmployee(name, salary, position, department){
        if(!name || !position || !department || !salary || salary < 0){
            throw new Error("Invalid input!");
        };

        const newEmployee = {
            name,
            salary: Number(salary),
            position
        };

        if(this.departments.hasOwnProperty(department) == false){
            this.departments[department] = [];
        }

        this.departments[department].push(newEmployee);
        return `New employee is hired. Name: ${name}. Position: ${position}`;
    };

    bestDepartment(){
        let biggestAvgSalary = 0;
        let bestDepartment;
        let bestDepartmentName = '';

        Object.entries(this.departments).forEach(([key, value]) =>{
            let currentDepartment = key;
            let currentAvgSalary = value.reduce((acc, cur)=>acc+cur.salary, 0)/value.length;

            if(biggestAvgSalary < currentAvgSalary){
                biggestAvgSalary = currentAvgSalary;
                bestDepartment = this.departments[currentDepartment];
                bestDepartmentName = currentDepartment;
            };
        });

        return `Best Department is: ${bestDepartmentName}\n` +
        `Average salary: ${biggestAvgSalary.toFixed(2)}\n`+
        bestDepartment
        .sort((a,b)=> b.salary - a.salary || a.name.localeCompare(b.name))
        .map(employee => `${employee.name} ${employee.salary} ${employee.position}`)
        .join('\n');
    }
}

let c = new Company();
c.addEmployee("Stanimir", 2000, "engineer", "Construction");
c.addEmployee("Pesho", 1500, "electrical engineer", "Construction");
c.addEmployee("Slavi", 500, "dyer", "Construction");
c.addEmployee("Stan", 2000, "architect", "Construction");
c.addEmployee("Stanimir", 1200, "digital marketing manager", "Marketing");
c.addEmployee("Pesho", 1000, "graphical designer", "Marketing");
c.addEmployee("Gosho", 1350, "HR", "Human resources");
console.log(c.bestDepartment());