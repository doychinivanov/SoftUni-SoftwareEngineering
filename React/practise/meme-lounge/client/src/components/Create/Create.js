import { createMeme } from "../../services/memeService";
import { useUser } from "../../context/UserContext";

const Create = ({history}) => {

    const currentUser = useUser();
    const token = currentUser.accessToken || null;

    const createNewMeme = async(ev) => {
        ev.preventDefault();

        const [title, description, imageUrl] = ev.target;

        if(title.value === '' || description.value === '' || imageUrl === '') {
            alert('All fields are required!');
            return null;
        }

        try{
            await createMeme({title: title.value, description: description.value, imageUrl: imageUrl.value}, token);
            history.push('/all');
        } catch(err){
            alert(err.message);
            return null;
        }

    }

    return (
        <section id="create-meme">
        <form onSubmit={createNewMeme} id="create-form">
            <div className="container">
                <h1>Create Meme</h1>
                <label htmlFor="title">Title</label>
                <input id="title" type="text" placeholder="Enter Title" name="title" />
                <label htmlFor="description">Description</label>
                <textarea id="description" placeholder="Enter Description" name="description"></textarea>
                <label htmlFor="imageUrl">Meme Image</label>
                <input id="imageUrl" type="text" placeholder="Enter meme ImageUrl" name="imageUrl" />
                <input type="submit" className="registerbtn button" value="Create Meme" />
            </div>
        </form>
    </section>
    );
}

export default Create;