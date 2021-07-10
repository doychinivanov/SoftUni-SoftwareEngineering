import * as elements from './src/util/setDomElements.js';
import { getStudents, createStudent } from './src/api/studentService.js';
import { createEl } from './src/util/createElements.js';

loadStudentsData();
elements.form.addEventListener('submit', registerNewStudent);

async function loadStudentsData() {
    try {
        const students = await getStudents();

        while(elements.tbody.lastElementChild){
            elements.tbody.removeChild(elements.tbody.lastElementChild);
        }

        Object.values(students).map(student => {
            const tr = createEl('tr');

            const nameTd = createEl('td', student.firstName);
            const lastNameTd = createEl('td', student.lastName);
            const facTd = createEl('td', student.facultyNumber);
            const grade = createEl('td', student.grade);

            tr.appendChild(nameTd);
            tr.appendChild(lastNameTd);
            tr.appendChild(facTd);
            tr.appendChild(grade);

            return tr;
        }).forEach(row => elements.tbody.appendChild(row));

    } catch (err) {
        elements.notifications.textContent = err.message;
        return;
    }
}

async function registerNewStudent(ev){
    ev.preventDefault();
    const formData = new FormData(ev.currentTarget);

    const firstName = formData.get('firstName');
    const lastName = formData.get('lastName');
    const facultyNumber = formData.get('facultyNumber');
    const grade = Number(formData.get('grade'));

    if(firstName == '' || lastName == '' || facultyNumber == '' || grade == ''){
        alert('All fields are required!');
        return;
    }

    ev.currentTarget.reset();
    try{
        await createStudent({firstName, lastName, facultyNumber, grade});
        loadStudentsData();
    } catch(err){
        elements.notifications.textContent = err.message;
        return;
    }
}