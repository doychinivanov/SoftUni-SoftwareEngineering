const router = require('express').Router();
const {body, validationResult} = require('express-validator');
const {errorParser} = require('../utils/errorParser');
const userService = require('../services/userService');
const {isOwner, isUser, isNotOwner} = require('../middlewares/guards');


router.get('/create', isUser(), (req, res) => {
    res.render('course/create');
});

router.post('/create', isUser(),
body('title').isLength({min:5}).withMessage('Course title must be at least 5 characters!').bail(),
body('description').isLength({max:50}).withMessage('Description can not exceed 50 symbols!').bail(),
body('imageUrl').custom((value)=>{if(!value.startsWith('http') || !value.startsWith('https')){throw new Error('The url must start with http or https')} return true}),
async  (req, res) => {

    const {errors} = validationResult(req);

    const courseData = {
        title: req.body.title.trim(),
        description: req.body.description.trim(),
        duration: req.body.duration.trim(),
        imageUrl: req.body.imageUrl.trim(),
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
            courseData
        };

        res.render('course/create', ctx);
    }


})

router.get('/:id', isUser(), async (req, res) =>{
    const ctx = {}

    try {
        const course = await req.storage.getCourseById(req.params.id);
        
        ctx.course = {
            _id: course._id,
            title: course.title,
            description: course.description,
            imageUrl: course.imageUrl,
            duration: course.duration,
            ownerId: course.owner,
            users: course.enrolledUsers.length,
            createdAt: course.createdAt,
            currentUserIsOwner: req.user._id == course.owner,
            currentUserHasEnrolled: course.enrolledUsers.includes(req.user._id)
        };
    } catch (err){
        ctx.errors = err.message;
    }

    res.render('course/details', ctx);
})


router.get('/edit/:id', isUser(), isOwner(), async(req,res)=>{
    const ctx = {};

    try{
        const course = await req.storage.getCourseById(req.params.id);
        
        ctx.course = {
            _id: course._id,
            title: course.title,
            description: course.description,
            imageUrl: course.imageUrl,
            duration: course.duration,
        };
    } catch(err){
        ctx.errors = err.message;
    }

    res.render('course/edit', ctx);
});

router.post('/edit/:id', isUser(), isOwner(), 
body('title').isLength({min:5}).withMessage('Course title must be at least 5 characters!').bail(),
body('description').isLength({max:50}).withMessage('Description can not exceed 50 symbols!').bail(),
body('imageUrl').custom((value)=>{if(!value.startsWith('http') || !value.startsWith('https')){throw new Error('The url must start with http or https')} return true}),
async(req,res) => {
    const {errors} = validationResult(req);

    const courseData = {
        title: req.body.title.trim(),
        description: req.body.description.trim(),
        duration: req.body.duration.trim(),
        imageUrl: req.body.imageUrl.trim(),
    };

    console.log(courseData)

    try{
        if(errors.length > 0){
            throw new Error(Object.values(errors).map(e => e.msg).join('\n'));
        }
        
        await req.storage.editCourse(req.params.id, courseData);

        res.redirect('/course/' + req.params.id);
    } catch(err){
        const ctx = {
            errors: errorParser(err),
            course: {
                title: courseData.title,
                description: courseData.description,
                duration: courseData.duration,
                imageUrl: courseData.imageUrl,
            }
        };

        res.render('course/edit', ctx);
    }
});

router.get('/delete/:id', isUser(), isOwner(), async(req,res)=>{

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
        await userService.joinCourse(userId, courseId);

        res.redirect(`/course/${courseId}`);
    } catch(err){
        ctx.errors = err.message;
        res.render('home', ctx);
    }
});

module.exports = router;