function makePosts(){
    class Post{
        constructor(title, content){
            this.title = title;
            this.content = content;
        }

        toString(){
            return `Post: ${this.title}\nContent: ${this.content}`
        }
    }

    class SocialMediaPost extends Post {
        constructor(title, content, likes, dislikes){
            super(title, content);
            this.likes = likes;
            this.dislikes = dislikes;
            this.comments = [];
        }

        addComment(comment){
            this.comments.push(comment);
        }

        toString(){
            if(this.comments.length === 0){
                return super.toString() + `\nRating: ${this.likes - this.dislikes}`
            } else {
                const outputComments = this.comments.map(comment => ` * ${comment}`)
                return super.toString() + `\nRating: ${this.likes - this.dislikes}\nComments:\n${outputComments.join('\n')}`
            }
        }
        

    }

    class BlogPost extends Post{
        constructor(title, contet, views){
            super(title, contet);
            this.views = views;
        }

        view(){
            this.views++
            return this;
        }

        toString(){
            return super.toString() + `\nViews: ${this.views}`
        }
    }

    return {
        Post,
        SocialMediaPost,
        BlogPost
    }
}

const classes = makePosts();
//Test Post Class
const post = new classes.Post('This is title', 'This is content');
console.log(post.toString());

//Test SocialMediaPost Class
const scm = new classes.SocialMediaPost('TestTitle', 'TestContent', 5, 10);
scm.addComment('1');
scm.addComment('2');
scm.addComment('3');
console.log(`-----------`);
console.log(scm.toString());

//Test BlogPost class
console.log(`------------`);
const blog = new classes.BlogPost('guitar post', 'smth about guitars', 17);
blog.view().view().view();
console.log(blog.toString());