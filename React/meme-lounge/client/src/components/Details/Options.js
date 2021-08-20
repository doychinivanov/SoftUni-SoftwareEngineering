import { Link } from "react-router-dom";

const Options = () => {
    return (
        <>
            <Link className="button warning" to="/edit/id">Edit</Link>
            <button className="button danger">Delete</button>
        </>
    );
}

export default Options;