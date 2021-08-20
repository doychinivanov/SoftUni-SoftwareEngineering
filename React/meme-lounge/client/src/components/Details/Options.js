import { Link } from "react-router-dom";
import { useHistory } from "react-router";

const Options = ({onDeleteMeme, token, memeId}) => {

    const history = useHistory();

    const deleteCurrentMeme = async (ev) => {
        ev.preventDefault();

        try{
            await onDeleteMeme(memeId, token);
            history.push('/all');
        } catch(err){
            alert(err.message);
            return null;
        }

    }

    return (
        <>
            <Link className="button warning" to="/edit/id">Edit</Link>
            <button onClick={deleteCurrentMeme} className="button danger">Delete</button>
        </>
    );
}

export default Options;