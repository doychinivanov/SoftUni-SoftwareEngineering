import { useState, useEffect } from "react";
import { getOneMeme, editMeme } from "../../services/memeService";
import { useUser } from '../../context/UserContext';


const Edit = ({history, match}) => {
    const memeId = match.params.memeId;
    const [meme, setMeme] = useState({});

    const currentUser = useUser();
    const token = currentUser.accessToken || null;

    useEffect(()=>{
        getOneMeme(memeId, token)
        .then(meme => setMeme(meme))

    }, [memeId, token])

    const editCurrentMeme = async (ev) => {
        ev.preventDefault();

        const [title, description, imageUrl] = ev.target;

        if(title.value === '' || description.value === '' || imageUrl === '') {
            alert('All fields are required!');
            return null;
        }

        try{
            await editMeme(memeId, {title: title.value, description: description.value, imageUrl: imageUrl.value}, token);
            history.push(`/details/${memeId}`);
        } catch(err){
            alert(err.message);
            return null;
        }
    }

    return (
        <section id="edit-meme">
        <form onSubmit={editCurrentMeme} id="edit-form">
            <h1>Edit Meme</h1>
            <div className="container">
                <label htmlFor="title">Title</label>
                <input id="title" type="text" placeholder="Enter Title" name="title" defaultValue={meme.title} />
                <label htmlFor="description">Description</label>
                <textarea id="description" placeholder="Enter Description" name="description" defaultValue={meme.description}></textarea>
                <label htmlFor="imageUrl">Image Url</label>
                <input id="imageUrl" type="text" placeholder="Enter Meme ImageUrl" name="imageUrl" defaultValue={meme.imageUrl} />
                <input type="submit" className="registerbtn button" value="Edit Meme" />
            </div>
        </form>
    </section>
    );
}

export default Edit;