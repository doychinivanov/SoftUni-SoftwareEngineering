import { html } from "../config/libraries.js";
import { loginUser } from '../controllers/userController.js';

const loginTemplate = (ctx) => html`
<section id="login-page" class="login">
    <form @submit=${(ev) => loginUser(ev, ctx)} id="login-form" action="" method="">
        <fieldset>
            <legend>Login Form</legend>
            <p class="field">
                <label for="email">Email</label>
                <span class="input">
                    <input type="text" name="email" id="email" placeholder="Email">
                </span>
            </p>
            <p class="field">
                <label for="password">Password</label>
                <span class="input">
                    <input type="password" name="password" id="password" placeholder="Password">
                </span>
            </p>
            <input class="button submit" type="submit" value="Login">
        </fieldset>
    </form>
</section>
`;

export const showLogin = (ctx) => {
    ctx.render(loginTemplate(ctx));
}