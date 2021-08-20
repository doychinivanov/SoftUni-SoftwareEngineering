import { Link } from "react-router-dom";
import { useHistory } from 'react-router';
import { useUpdateUser } from '../../context/UserContext';
import { register } from "../../services/userService";


const Register = () => {

    const addNewUser = useUpdateUser();
    const history = useHistory();

    const registerUser = async(ev) =>{
        ev.preventDefault();
        const [username, email, password, repeatPass, gender] = ev.target;

        if(username.value === '' || email.value === '' || password.value === '' || gender.value === undefined){
            alert('All fields are required!');
            return null;
        }

        if(password.value !== repeatPass.value){
            alert('Passwords don\'t match!');
            return null;
        }

        try{
            const userObject = await register({email:email.value, token:null, password:password.value, gender:gender.value});
            addNewUser({accessToken: userObject.accessToken, email: userObject.email, gender:userObject.gender, username:userObject.username});
            history.push('/all');
        } catch(err){
            alert(err.message);
            return null;
        }
    }

    return (
        <section id="register">
        <form onSubmit={registerUser} id="register-form">
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