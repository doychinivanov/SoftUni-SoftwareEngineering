import {html} from 'https://unpkg.com/lit-html?module';

export const ulTemplate = (towns) => html`
    <ul>
        ${towns.map(liTemplate)}
    </ul>
`;

const liTemplate = (town) => html`
    <li>${town}</li>
`;