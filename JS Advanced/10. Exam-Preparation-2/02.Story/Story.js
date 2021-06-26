class Story {
    constructor(title, creator) {
        this.title = String(title);
        this.creator = String(creator);
        this._comments = [];
        this._likes = [];
        this._id = 1;
    };

    get likes() {
        if (this._likes.length == 0) {
            return `${this.title} has 0 likes`
        } else if (this._likes.length == 1) {
            return `${this._likes[0]} likes this story!`;
        } else {
            return `${this._likes[0]} and ${this._likes.length - 1} others like this story!`
        }
    };

    like(username) {
        if (this._likes.includes(username)) {
            throw new Error(`You can't like the same story twice!`);
        }

        if (this.creator == username) {
            throw new Error(`You can't like your own story!`);
        }

        this._likes.push(username);
        return `${username} liked ${this.title}!`;

    };

    dislike(username) {
        if (this._likes.includes(username) == false) {
            throw new Error('You can\'t dislike this story!');
        };

        this._likes.splice(this._likes.indexOf(username), 1);
        return `${username} disliked ${this.title}`
    };

    comment(username, content, id) {
        if (!id || !this._comments.find(c => c.id == id)) {
            this._comments.push({
                id: this._id,
                username: username,
                content: content,
                replies: []
            });

            this._id++;
            return `${username} commented on ${this.title}`
        } else {
            const currentComment = this._comments.find(c => c.id == id);
            currentComment.replies.push({
                id: `${currentComment.id}.${currentComment.replies.length + 1}`,
                username: username,
                content: content
            });

            return `You replied successfully`;
        }
    };

    toString(sortingType) {
        const outPut = [];
        outPut.push(`Title: ${this.title}\nCreator: ${this.creator}\nLikes: ${this._likes.length}\nComments:`)

        let comments = '';

        if (this._comments.length>0) {
            if (sortingType == 'username') {
                comments = this._comments
                    .sort((a, b) => a.username.localeCompare(b.username))
                    .map(c => `-- ${c.id}. ${c.username}: ${c.content}${c.replies.sort((a, b) => a.username.localeCompare(b.username)).map(r => `\n--- ${r.id}. ${r.username}: ${r.content}`).join('')}`).join('\n');
            } else if (sortingType == 'asc') {
                comments = this._comments
                    .sort((a, b) => a.id - b.id)
                    .map(c => `-- ${c.id}. ${c.username}: ${c.content}${c.replies.sort((a, b) => a.id - b.id).map(r => `\n--- ${r.id}. ${r.username}: ${r.content}`).join('')}`).join('\n');
            } else if (sortingType == 'desc') {
                comments = this._comments
                    .sort((a, b) => b.id - a.id)
                    .map(c => `-- ${c.id}. ${c.username}: ${c.content}${c.replies.sort((a, b) => b.id - a.id).map(r => `\n--- ${r.id}. ${r.username}: ${r.content}`).join('')}`).join('\n');
            }
            outPut.push(comments);
        }
        return outPut.join('\n')
    };
};


let art = new Story("My Story", "Anny");
art.like("John");
console.log(art.likes);
art.dislike("John");
console.log(art.likes);
art.comment("Sammy", "Some Content");
console.log(art.comment("Ammy", "New Content"));
art.comment("Zane", "Reply", 1);
art.comment("Jessy", "Nice :)");
console.log(art.comment("SAmmy", "Reply@", 1));
console.log()
console.log(art.toString('username'));
