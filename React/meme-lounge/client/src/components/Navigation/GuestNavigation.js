import { NavLink } from "react-router-dom";

const GuestNavigation = () => {
    return (
        <div className="guest">
            <div className="profile">
                <NavLink to="/login">Login</NavLink>
                <NavLink to="/register">Register</NavLink>
            </div>
            <NavLink exact to="/">Home Page</NavLink>
        </div>
    );
}

export default GuestNavigation;