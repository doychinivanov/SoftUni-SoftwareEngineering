import {useUser, useUpdateUser} from '../../context/UserContext';
import {NavLink} from 'react-router-dom';

import UserNavigation from '../Navigation/UserNavigation';
import GuestNavigation from '../Navigation/GuestNavigation';

const Header = () => {

    const currentUser = useUser();
    const addNewUser = useUpdateUser();

    return(
        <nav>
        <NavLink to="/all">All Memes</NavLink>

        {Object.keys(currentUser).length > 0 ? <UserNavigation addNewUser={addNewUser} user={currentUser} /> : <GuestNavigation/>}

    </nav>
    );
}

export default Header;