import {useUser} from '../context/UserContext';
import { Redirect } from 'react-router-dom';

const isAuth = (WrappedComponent) => {

    const ComponentWrapper = (props) => {
        const currentUser = useUser();

        if(Object.keys(currentUser).length === 0){
            return <Redirect to="/" />;
        }

        return <WrappedComponent {...props} />;
    }

    return ComponentWrapper;
}

export default isAuth;