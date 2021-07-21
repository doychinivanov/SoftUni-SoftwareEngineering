import {html} from 'https://unpkg.com/lit-html?module';

export const ulTemplate = (towns, query = '') => html`
    <ul>
        ${towns.map(town => liTemplate(town, query))}
    </ul>
`;

const liTemplate = (town, query) => html`
    <li class = ${(query && town.toLowerCase().includes(query.toLowerCase())) ? 'active' : ''} >${town}</li>
`;