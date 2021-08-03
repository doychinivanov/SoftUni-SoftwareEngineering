import { html } from '../config/libraries.js';
import { loginUser } from '../controllers/userController.js';

const loginTemplate = (ctx) => html`
    <section id="login">
        <form @submit=${(ev) => loginUser(ev, ctx)} id="login-form">
            <div class="container">
                <h1>Login</h1>
                <label for="email">Email</label>
                <input id="email" placeholder="Enter Email" name="email" type="text">
                <label for="password">Password</label>
                <input id="password" type="password" placeholder="Enter Password" name="password">
                <input type="submit" class="registerbtn button" value="Login">
                <div class="container signin">
                    <p>Dont have an account?<a href="#">Sign up</a>.</p>
                </div>
            </div>
        </form>
    </section>
`;

export const showLogin = (ctx) => {
    ctx.render(loginTemplate(ctx));
    ctx.setUserNav();
}