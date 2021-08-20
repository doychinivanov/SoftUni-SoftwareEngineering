import { Link } from "react-router-dom";

const Profile = () => {
    return(
        <section id="user-profile-page" className="user-profile">
        <article className="user-info">
            <img id="user-avatar-url" alt="user-profile" src="/images/female.png" />
            <div className="user-content">
                <p>Username: Mary</p>
                <p>Email: mary@abv.bg</p>
                <p>My memes count: 2</p>
            </div>
        </article>
        <h1 id="user-listings-title">User Memes</h1>
        <div className="user-meme-listings">
            <div className="user-meme">
                <p className="user-meme-title">Java Script joke</p>
                <img className="userProfileImage" alt="meme-img" src="/images/1.png" />
                <Link className="button" to="/details/id">Details</Link>
            </div>
            <div className="user-meme">
                <p className="user-meme-title">Bad code can present some problems</p>
                <img className="userProfileImage" alt="meme-img" src="/images/3.png" />
                <Link className="button" to="/details/id">Details</Link>
            </div>

            <p className="no-memes">No memes in database.</p>
        </div>
    </section>
    );
}

export default Profile;