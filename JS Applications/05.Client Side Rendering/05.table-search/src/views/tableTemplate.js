import { html } from 'https://unpkg.com/lit-html?module';
import { search } from '../controllers/tableController.js';

export const tableTemplate = (data, query) => html`
<thead>
    <tr>
        <th>Student name</th>
        <th>Student email</th>
        <th>Student course</th>
    </tr>
</thead>

<tbody>
    ${data.map(person => tableRowTemplate(person, query))}
</tbody>

<tfoot>
    <tr>
        <td colspan="3">
            <input type="text" id="searchField" />
            <button @click="${search}" type="button" id="searchBtn">Search</button>
        </td>
    </tr>
</tfoot>
`;

const tableRowTemplate = (person, query) => html`
<tr class="${query && (person.firstName.toLowerCase().includes(query.toLowerCase()) || person.lastName.toLowerCase().includes(query.toLowerCase()) || person.email.toLowerCase().includes(query.toLowerCase()) || person.course.toLowerCase().includes(query.toLowerCase())) ? 'select' :  ''}">
    <td>${person.firstName} ${person.lastName}</td>
    <td>${person.email}</td>
    <td>${person.course}</td>
</tr>
`