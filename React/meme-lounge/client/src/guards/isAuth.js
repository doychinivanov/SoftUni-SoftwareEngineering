import {useUser} from '../context/UserContext';
import { useHistory } from 'react-router';

const isAuth = (WrappedComponent) => {

    const ComponentWrapper = (props) => {
        const history = useHistory();
        const currentUser = useUser();

        if(Object.keys(currentUser).length === 0){
            history.push('/');
            return null;
        }

        return <WrappedComponent {...props} />;
    }

    return ComponentWrapper;
}

export default isAuth;