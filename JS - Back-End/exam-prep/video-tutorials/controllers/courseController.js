const router = require('express').Router();
const {body, validationResult} = require('express-validator');
const {errorParser} = require('../utils/errorParser');
const userService = require('../services/userService');
const {isOwner, isUser, isNotOwner} = require('../middlewares/guards');

router.get('/create', isUser(), (req, res) => {
    res.render('course/create', {title: 'Create Course'});
});

router.post('/create', isUser(),
body('title').isLength({min:4}).withMessage('Course title must be at least 4 characters!').bail(),
body('description').isLength({min:20}).withMessage('Description can not be less than 20 symbols!').bail(),
body('imageUrl').custom((value)=>{if(!value.startsWith('http') || !value.startsWith('https')){throw new Error('The url must start with http or https')} return true}),
async  (req, res) => {

    const {errors} = validationResult(req);

    const courseData = {
        title: req.body.title.trim(),
        description: req.body.description.trim(),
        imageUrl: req.body.imageUrl.trim(),
        isPublic: req.body.isPublic == 'on' ? true : false,
        ownerId: req.user._id
    };

    try{
        if(errors.length > 0){
            throw new Error(Object.values(errors).map(e => e.msg).join('\n'));
        }
        
        await req.storage.createCourse(courseData);

        res.redirect('/');
    } catch(err){
        const ctx = {
            errors: errorParser(err),
            courseData,
            title: 'Create Course'
        };

        res.render('course/create', ctx);
    }


});

router.get('/details/:id', isUser(), async (req, res) =>{
    const ctx = {}

    try {
        const course = await req.storage.getCourseById(req.params.id);
        
        ctx.course = {
            _id: course._id,
            title: course.title,
            description: course.description,
            imageUrl: course.imageUrl,
            ownerId: course.owner,
            users: course.usersEnrolled.length,
            createdAt: course.createdAt,
            currentUserIsOwner: req.user._id == course.owner,
            currentUserHasEnrolled: course.usersEnrolled.includes(req.user._id)
        };

        ctx.title = 'Details Page'
    } catch (err){
        ctx.errors = err.message;
    }

    res.render('course/details', ctx);
});


router.get('/edit/:id', isUser(),  isOwner(), async(req,res)=>{
    const ctx = {};

    try{
        const course = await req.storage.getCourseById(req.params.id);
        
        ctx.course = {
            _id: course._id,
            title: course.title,
            description: course.description,
            imageUrl: course.imageUrl,
            isPublic: course.isPublic
        };

        ctx.title = 'Edit Page'
    } catch(err){
        ctx.errors = err.message;
    }

    res.render('course/edit', ctx);
});

router.post('/edit/:id',  isOwner(), isUser(), 
body('title').isLength({min:4}).withMessage('Course title must be at least 4 characters!').bail(),
body('description').isLength({min:20}).withMessage('Description must be at least 20 symbols!').bail(),
body('imageUrl').custom((value)=>{if(!value.startsWith('http') || !value.startsWith('https')){throw new Error('The url must start with http or https')} return true}),
async(req,res) => {
    const {errors} = validationResult(req);

    const courseData = {
        title: req.body.title.trim(),
        description: req.body.description.trim(),
        imageUrl: req.body.imageUrl.trim(),
    };

    try{
        if(errors.length > 0){
            throw new Error(Object.values(errors).map(e => e.msg).join('\n'));
        }
        
        await req.storage.editCourse(req.params.id, courseData);

        res.redirect('/course/details/' + req.params.id);
    } catch(err){
        const ctx = {
            errors: errorParser(err),
            course: {
                title: courseData.title,
                description: courseData.description,
                imageUrl: courseData.imageUrl,
            }
        };

        res.render('course/edit', ctx);
    }
});

router.get('/delete/:id', isUser(), isOwner(), async(req, res)=>{
    const ctx = {}

    try{
        await req.storage.deleteCourse(req.params.id);
        res.redirect('/');
    } catch (err){
        ctx.errors = err.message;
        res.render('home', ctx);
    }
});

router.get('/enroll/:id', isUser(), isNotOwner(), async (req, res)=>{
    const userId = req.user._id;
    const courseId = req.params.id;

    const ctx = {};

    try{
        await req.storage.addParticipant(courseId, userId);
        await userService.enrollCourse(userId, courseId);

        res.redirect(`/course/details/${courseId}`);
    } catch(err){
        console.log(err.message)
        ctx.errors = err.message;
        res.render('home', ctx);
    }
});

module.exports = router;