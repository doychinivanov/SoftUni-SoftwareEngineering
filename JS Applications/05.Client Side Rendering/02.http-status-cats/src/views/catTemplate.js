import { html } from 'https://unpkg.com/lit-html?module';

export const ulTemplate = (cats) => html`
    <ul>
        ${cats.map(liTemplate)}
    </ul>
`;

const liTemplate = (cat) => html`
    <li>
        <img src="./images/${cat.imageLocation}.jpg" width="250" height="250" alt="Card image cap">
        <div class="info">
            <button class="showBtn">Show status code</button>
            <div class="status" style="display: none" id="${cat.statusCode}">
                <h4>Status Code: ${cat.statusCode}</h4>
                <p>${cat.statusMessage}</p>
            </div>
        </div>
    </li>
`;