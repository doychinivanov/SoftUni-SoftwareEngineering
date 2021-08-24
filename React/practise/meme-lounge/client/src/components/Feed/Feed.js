import MemeCard from '../MemeCard/index';
import { useUser } from '../../context/UserContext';
import { useEffect, useState } from 'react';
import { getAllMemesSorted } from '../../services/memeService';

const Feed = () => {

    const [memes, setMemes] = useState([]);

    const currentUser = useUser();
    const token = currentUser.accessToken || null;

    useEffect(()=>{
        getAllMemesSorted(token)
        .then(memes => setMemes(memes))
    },[token]);

    return (
        <section id="meme-feed">
        <h1>All Memes</h1>
        <div id="memes">
           
           {memes.length > 0 ? memes.map(MemeCard) : <p className="no-memes">No memes in database.</p>}
        </div>
    </section>
    );
}

export default Feed;