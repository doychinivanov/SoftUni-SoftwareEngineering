import { NavLink } from "react-router-dom";

const UserNavigation = ({addNewUser}) => {
    return (
        <div className="user">
            <NavLink to="/create">Create Meme</NavLink>
            <div className="profile">
                <span>Welcome, email</span>
                <NavLink to="/profile">My Profile</NavLink>
                <NavLink onClick={(ev) => { ev.preventDefault(); addNewUser({}) }} to="/logout">Logout</NavLink>
            </div>
        </div>
    );
}

export default UserNavigation;