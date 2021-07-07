import { html } from '../node_modules/lit-html/lit-html.js';
import { toggle } from '../util/toggleInfo.js';

export const holder = (users) => html`
    <div>
        ${Object.values(users).map((user, i) => profileView(user, i))}
    </div>
`;

const profileView = (user, i) => html`
<div class="profile">
    <img src="/static/img/iconProfile2.png" class="userIcon" />
    <fieldset></fieldset>
    <label>Lock</label>
    <input type="radio" name="user${i + 1}Locked" value="lock" checked>
    <label>Unlock</label>
    <input type="radio" name="user${i + 1}Locked" value="unlock"><br>
    <hr>
    <label>Username</label>
    <input type="text" name="username" value="${user.username}" disabled readonly />
    <div id="user${i + 1}HiddenFields">
        <hr>
        <label>Email:</label>
        <input type="email" name="email" value="${user.email}" disabled readonly />
        <label>Age:</label>
        <input type="email" name="age" value="${user.age}" disabled readonly />
    </div>
    <button @click="${(ev)=>toggle(ev)}">Show more</button>
</div>
`;