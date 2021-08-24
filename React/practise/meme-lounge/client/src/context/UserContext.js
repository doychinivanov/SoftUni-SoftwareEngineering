import React, {useContext, useState} from 'react';

const UserContext = React.createContext();
const UserUpdateContext = React.createContext();

export const useUser = () => {
    return useContext(UserContext);
}

export const useUpdateUser = () => {
    return useContext(UserUpdateContext);
}

export const UserProvider = ({children}) => {
    const [user, setUser] = useState({});

    const addNewUser = (user) =>{
        setUser(user);
    }

    return (
        <UserContext.Provider value={user}>
            <UserUpdateContext.Provider value={addNewUser}>
                {children}
            </UserUpdateContext.Provider>
        </UserContext.Provider>
    );
}