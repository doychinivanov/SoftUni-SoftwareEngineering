import { NavLink } from "react-router-dom";
import { logout } from "../../services/userService";

const UserNavigation = ({addNewUser, user}) => {

    const logoutUser = async(ev) => {
        ev.preventDefault(); 
        try{
            console.log(user.accessToken)
            await logout(user.accessToken);
            addNewUser({});
        } catch(err){
            alert(err.message);
            return null;
        }

    }

    return (
        <div className="user">
            <NavLink to="/create">Create Meme</NavLink>
            <div className="profile">
                <span>Welcome, email</span>
                <NavLink to="/profile">My Profile</NavLink>
                <NavLink onClick={logoutUser} to="/logout">Logout</NavLink>
            </div>
        </div>
    );
}

export default UserNavigation;