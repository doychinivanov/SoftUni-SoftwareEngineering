const Edit = () => {
    return (
        <section id="edit-meme">
        <form id="edit-form">
            <h1>Edit Meme</h1>
            <div className="container">
                <label htmlFor="title">Title</label>
                <input id="title" type="text" placeholder="Enter Title" name="title" />
                <label htmlFor="description">Description</label>
                <textarea id="description" placeholder="Enter Description" name="description" defaultValue={'this is description'}></textarea>
                <label htmlFor="imageUrl">Image Url</label>
                <input id="imageUrl" type="text" placeholder="Enter Meme ImageUrl" name="imageUrl" />
                <input type="submit" className="registerbtn button" value="Edit Meme" />
            </div>
        </form>
    </section>
    );
}

export default Edit;