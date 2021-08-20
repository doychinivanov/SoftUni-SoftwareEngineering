import { Link } from "react-router-dom";

const Register = () => {
    return (
        <section id="register">
        <form id="register-form">
            <div className="container">
                <h1>Register</h1>
                <label htmlFor="username">Username</label>
                <input id="username" type="text" placeholder="Enter Username" name="username" />
                <label htmlFor="email">Email</label>
                <input id="email" type="text" placeholder="Enter Email" name="email" />
                <label htmlFor="password">Password</label>
                <input id="password" type="password" placeholder="Enter Password" name="password" />
                <label htmlFor="repeatPass">Repeat Password</label>
                <input id="repeatPass" type="password" placeholder="Repeat Password" name="repeatPass" />
                <div className="gender">
                    <input type="radio" name="gender" id="female" value="female" />
                    <label htmlFor="female">Female</label>
                    <input type="radio" name="gender" id="male" value="male" />
                    <label htmlFor="male">Male</label>
                </div>
                <input type="submit" className="registerbtn button" value="Register" />
                <div className="container signin">
                    <p>Already have an account?<Link to="/login">Sign in</Link>.</p>
                </div>
            </div>
        </form>
    </section>
    );
}

export default Register;