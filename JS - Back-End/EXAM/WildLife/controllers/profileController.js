const router = require('express').Router();
const postService = require('../services/postService');
const { isUser } = require('../middlewares/guards');

router.get('/profile', isUser(), async (req, res) => {
    const userPosts = await postService.getPostsByAuthorId(req.user._id);

    const ctx = {
        userData: { ...req.user },
        title: 'My Posts'
    }

    ctx.userPosts = userPosts.map(currentPost => ({
        _id: currentPost._id,
        title: currentPost.title,
        keyword: currentPost.keyword,
        description: currentPost.description,
        location: currentPost.location,
        imageUrl: currentPost.imageUrl,
        authorName: `${req.user.firstName} ${req.user.lastName}`,
        voters: currentPost.voters.length,
        rating: currentPost.rating,
        date: currentPost.date,
    }))

    res.render('authViews/myPosts', ctx);
});

module.exports = router;