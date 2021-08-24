const UserCard = ({user, memesCount}) => {

    return (
        <article className="user-info">
            <img id="user-avatar-url" alt="user-profile" src={`/images/${user.gender}.png`} />
            <div className="user-content">
                <p>Username: {user.username}</p>
                <p>Email: {user.email}</p>
                <p>My memes count: {memesCount}</p>
            </div>
        </article>
    );
}

export default UserCard;