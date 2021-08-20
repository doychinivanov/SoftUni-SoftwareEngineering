import { useUser } from '../../context/UserContext';
import { useEffect, useState } from 'react';
import { getMemesByUserId } from "../../services/memeService";

import UserCard from './UserCard';
import MemeCard from "../MemeCard";

const Profile = () => {

    const [memes, setMemes] = useState([]);

    const currentUser = useUser();
    const token = currentUser.accessToken || null;
    const userId = currentUser._id || null;

    useEffect(()=>{
        getMemesByUserId(userId, token)
        .then(memes => setMemes(memes))
    },[userId,token]);

    return(
        <section id="user-profile-page" className="user-profile">

        <UserCard user={currentUser} memesCount={memes.length}/>

        <h1 id="user-listings-title">User Memes</h1>
        <div className="user-meme-listings">

        {memes.length > 0 ? memes.map(MemeCard) : <p className="no-memes">No memes in database.</p>}
        </div>
    </section>
    );
}

export default Profile;