import {html} from 'https://unpkg.com/lit-html?module';

export const optionsTemplate = (options) => html`
    <select id="menu">
        ${options.map(optionsView)}
    </select>
`;

const optionsView = (option) => html`
    <option id="${option._id}">${option.text}</option>
`;