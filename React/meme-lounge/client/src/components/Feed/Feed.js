import MemeCard from '../MemeCard/index';

const Feed = () => {
    return (
        <section id="meme-feed">
        <h1>All Memes</h1>
        <div id="memes">
           
           <MemeCard></MemeCard>
        <p className="no-memes">No memes in database.</p>
        </div>
    </section>
    );
}

export default Feed;