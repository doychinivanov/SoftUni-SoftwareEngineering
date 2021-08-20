import { Link } from "react-router-dom";

const MemeCard = () => {
    return (
        <div className="meme">
        <div className="card">
            <div className="info">
                <p className="meme-title">Debugging</p>
                <img className="meme-image" alt="meme-img" src="/images/2.png" />
            </div>
            <div id="data-buttons">
                <Link className="button" to="/details/id">Details</Link>
            </div>
        </div>
    </div>
    );
}

export default MemeCard;