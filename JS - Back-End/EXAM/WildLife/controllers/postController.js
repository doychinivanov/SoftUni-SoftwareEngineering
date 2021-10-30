const router = require('express').Router();
const {body, validationResult} = require('express-validator');
const {errorParser} = require('../utils/errorParser');
const {isUser, isOwner, isNotOwner} = require('../middlewares/guards');


router.get('/create', isUser(), (req, res) => {
    res.render('post/create', {title: 'Create Page'});
});


router.post('/create', isUser(),
body('title').isLength({min:6}).withMessage('Post title must be at least 6 characters!').bail(),
body('keyword').isLength({min:6}).withMessage('Keyword must be at least 6 characters!').bail(),
body('location').isLength({max:10}).withMessage('Location must be at maximum 10 characters!').bail(),
body('date').isLength({ min: 10, max:10 }).withMessage('Date must be exactly 10 characters!').bail(),
body('description').isLength({min:8}).withMessage('Description can not be less than 8 symbols!').bail(),
body('imageUrl').custom((value)=>{if(!value.startsWith('http') || !value.startsWith('https')){throw new Error('The url must start with http or https')} return true}),
async  (req, res) => {

    const {errors} = validationResult(req);

    const postData = {
        title: req.body.title.trim(),
        keyword: req.body.keyword.trim(),
        location: req.body.location.trim(),
        description: req.body.description.trim(),
        date: req.body.date.trim(),
        imageUrl: req.body.imageUrl.trim(),
        author: req.user._id
    };

    try{
        if(errors.length > 0){
            throw new Error(Object.values(errors).map(e => e.msg).join('\n'));
        }
        
        await req.storage.createPost(postData);

        res.redirect('catalog');
    } catch(err){
        const ctx = {
            errors: errorParser(err),
            postData,
            title: 'Create Page'
        };

        res.render('post/create', ctx);
    }


});

router.get('/catalog', async(req, res) =>{
    const ctx = {};
    ctx.title = 'Catalog Page';
    ctx.user = req.user;

    try{
        const posts = await req.storage.getAllPosts();

        ctx.posts = posts.map(currentPost => ({
            _id: currentPost._id,
            title: currentPost.title,
            keyword: currentPost.keyword,
            description: currentPost.description,
            location: currentPost.location,
            imageUrl: currentPost.imageUrl,
            author: currentPost.author,
            voters: currentPost.voters.length,
            rating: currentPost.rating,
            date: currentPost.date,
        }));
    } catch(err){
        ctx.errors = err.message;
    }


    res.render('post/allPosts', ctx)
});


router.get('/details/:id', async (req, res) =>{
    const ctx = {}

    try {
        const post = await req.storage.getPostById(req.params.id);
        
        ctx.post = {
            _id: post._id,
            title: post.title,
            keyword: post.keyword,
            description: post.description,
            location: post.location,
            imageUrl: post.imageUrl,
            authorName: `${post.author.firstName} ${post.author.lastName}`,
            voters: post.voters.map(x => x.email).join(', '),
            rating: post.rating,
            date: post.date,
            isOwner: req.user ? req.user._id === post.author._id.toString() : false,
            hasVoted: req.user ? post.voters.find(x => x._id.toString() === req.user._id) : false,
        };
        
        ctx.title = 'Details Page'
    } catch (err){
        console.log(err.message)
        ctx.errors = err.message;
    }

    res.render('post/details', ctx);
});

router.get('/delete/:id', isUser(), isOwner(), async(req, res)=>{
    const ctx = {}

    try{
        await req.storage.deletePost(req.params.id);
        res.redirect('catalog');
    } catch (err){
        ctx.errors = err.message;
        res.render('post/details', ctx);
    }
});

router.get('/edit/:id', isUser(),  isOwner(), async(req,res)=>{
    const ctx = {};
    ctx.title = 'Edit Page'
    try{
        const post = await req.storage.getPostById(req.params.id);
        
        ctx.post = {
            _id: post._id,
            title: post.title,
            keyword: post.keyword,
            description: post.description,
            location: post.location,
            imageUrl: post.imageUrl,
            date: post.date,
        };
    } catch(err){
        ctx.errors = err.message;
    }

    res.render('post/edit', ctx);
});

router.post('/edit/:id', isUser(), isOwner(),
body('title').isLength({min:6}).withMessage('Post title must be at least 6 characters!').bail(),
body('keyword').isLength({min:6}).withMessage('Keyword must be at least 6 characters!').bail(),
body('location').isLength({max:10}).withMessage('Location must be at maximum 10 characters!').bail(),
body('date').isLength({ min: 10, max:10 }).withMessage('Date must be exactly 10 characters!').bail(),
body('description').isLength({min:8}).withMessage('Description can not be less than 8 symbols!').bail(),
body('imageUrl').custom((value)=>{if(!value.startsWith('http') || !value.startsWith('https')){throw new Error('The url must start with http or https')} return true}),
async  (req, res) => {
    const {errors} = validationResult(req);

    const postData = {
        title: req.body.title.trim(),
        keyword: req.body.keyword.trim(),
        location: req.body.location.trim(),
        description: req.body.description.trim(),
        date: req.body.date.trim(),
        imageUrl: req.body.imageUrl.trim(),
    };

    try{
        if(errors.length > 0){
            throw new Error(Object.values(errors).map(e => e.msg).join('\n'));
        }
        
        await req.storage.updatePost(req.params.id, postData);

        res.redirect('/post/details/' + req.params.id);
    } catch(err){
        const ctx = {
            errors: errorParser(err),
            postData,
            title: 'Edit Page'
        };

        res.render('post/create', ctx);
    }
});

router.get('/like/:id', isUser(), isNotOwner(), async(req, res) => {
    const userId = req.user._id;
    const postId = req.params.id;

    const ctx = {};

    try{
        await req.storage.likePost(userId, postId);

        res.redirect(`/post/details/${postId}`);
    } catch(err){
        console.log(err.message)
        ctx.errors = err.message;
        res.render('post/details', ctx);
    }
});

router.get('/dislike/:id', isUser(), isNotOwner(), async(req, res) => {
    const userId = req.user._id;
    const postId = req.params.id;

    const ctx = {};

    try{
        await req.storage.dislikePost(userId, postId);

        res.redirect(`/post/details/${postId}`);
    } catch(err){
        console.log(err.message)
        ctx.errors = err.message;
        res.render('post/details', ctx);
    }
});

module.exports = router;