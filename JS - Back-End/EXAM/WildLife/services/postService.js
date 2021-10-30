const Post = require('../models/Post');

const createPost = async (postData) => {
    const post = new Post({
        title: postData.title,
        keyword: postData.keyword,
        location: postData.location,
        description: postData.description,
        date: postData.date,
        imageUrl: postData.imageUrl,
        author: postData.author
    });

    return post.save();
};

const getAllPosts = async () => {
    return Post.find({});
}

const getPostById = async (postId) => {
    return Post.findById(postId).populate('author').populate('voters');
}

const deletePost = async (postId) => {
    return Post.findByIdAndDelete(postId);
}

const getPostsByAuthorId = async (id) => {
    return Post.find({ 'author': id });
};

const updatePost = async (postId, postData) => {
    const post = await Post.findById(postId);

    post.title = postData.title;
    post.keyword = postData.keyword;
    post.location = postData.location;
    post.description = postData.description;
    post.date = postData.date;
    post.imageUrl = postData.imageUrl;

    return post.save();
}

const likePost = async (userId, postId) => {
    const post = await Post.findById(postId);

    post.voters.push(userId);
    post.rating += 1;

    return post.save();
}

const dislikePost = async (userId, postId) => {
    const post = await Post.findById(postId);

    post.voters.push(userId);
    post.rating -= 1;

    return post.save();
}

module.exports = {
    createPost,
    getAllPosts,
    getPostById,
    deletePost,
    getPostsByAuthorId,
    updatePost,
    likePost,
    dislikePost
}