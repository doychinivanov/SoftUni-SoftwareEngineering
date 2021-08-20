import Options from './Options';
import { useUser } from '../../context/UserContext';
import { useEffect, useState } from 'react';
import { getOneMeme, deleteMeme } from "../../services/memeService";

const Details = ({match}) => {
    const memeId = match.params.memeId; 

    const [currentMeme, setCurrentMeme] = useState([]);

    const currentUser = useUser();
    const token = currentUser.accessToken || null;

    useEffect(()=>{
        getOneMeme(memeId, token)
        .then(meme => setCurrentMeme(meme))
    },[memeId, token]);

    return (
        <section id="meme-details">
        <h1>Meme Title: {currentMeme.title}</h1>
        <div className="meme-details">
            <div className="meme-img">
                <img alt="meme-alt" src={currentMeme.imageUrl} />
            </div>
            <div className="meme-description">
                <h2>Meme Description</h2>
                <p>
                    {currentMeme.description}
                </p>

                {currentMeme._ownerId === currentUser._id ? <Options onDeleteMeme={deleteMeme} token={token} memeId={memeId}/> : ''}
                
            </div>
        </div>
    </section>
    );
}

export default Details;