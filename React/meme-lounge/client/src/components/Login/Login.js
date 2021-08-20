import { useHistory } from 'react-router';
import {Link} from 'react-router-dom';
import {login} from '../../services/userService';
import { useUpdateUser } from '../../context/UserContext';

const Login = () => {

    const addNewUser = useUpdateUser();
    const history = useHistory();

    const loginUser = async(ev)=>{
        ev.preventDefault();
        const [email, password] = ev.target;
        
        if(email.value === '' || password.value === ''){
            alert('No-no-no');
        } else {
            const userObject = await login({email:email.value, token:null, password:password.value});
            addNewUser({_id: userObject._id, accessToken: userObject.accessToken, email: userObject.email, gender:userObject.gender, username:userObject.username});
            history.push('/all');
        }
    }

    return (
        <section id="login">
        <form onSubmit={loginUser} id="login-form">
            <div className="container">
                <h1>Login</h1>
                <label htmlFor="email">Email</label>
                <input id="email" placeholder="Enter Email" name="email" type="text"/>
                <label htmlFor="password">Password</label>
                <input id="password" type="password" placeholder="Enter Password" name="password"/>
                <input type="submit" className="registerbtn button" value="Login"/>
                <div className="container signin">
                    <p>Dont have an account?<Link to="/register">Sign up</Link>.</p>
                </div>
            </div>
        </form>
    </section>
    );
};

export default Login;