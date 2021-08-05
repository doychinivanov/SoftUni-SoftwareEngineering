import { html } from '../config/libraries.js';
import { registerUser } from '../controllers/userController.js';

const registerTemplate = (ctx) => html`
<section id="register">
    <div class="container">
        <form @submit=${(ev) => registerUser(ev,ctx)} id="register-form">
            <h1>Register</h1>
            <p>Please fill in this form to create an account.</p>
            <hr>

            <p>Username</p>
            <input type="text" placeholder="Enter Username" name="username" required>

            <p>Password</p>
            <input type="password" placeholder="Enter Password" name="password" required>

            <p>Repeat Password</p>
            <input type="password" placeholder="Repeat Password" name="repeatPass" required>
            <hr>

            <input type="submit" class="registerbtn" value="Register">
        </form>
        <div class="signin">
            <p>Already have an account?
                <a href="/login">Sign in</a>.
            </p>
        </div>
    </div>
</section>
`;

export const showRegister = (ctx) => {
    ctx.render(registerTemplate(ctx));
    ctx.setUserNav();
}