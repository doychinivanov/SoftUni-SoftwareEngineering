const router = require('express').Router();

router.get('/', async (req,res)=>{
    const ctx = {}
    ctx.title = 'Home Page'
    ctx.user = req.user;

    try{
        const courses = await req.storage.getAllCourses();
    
        ctx.courses = courses.map(currentCourse => ({
            _id: currentCourse._id,
            title: currentCourse.title,
            description: currentCourse.description,
            imageUrl: currentCourse.imageUrl,
            ownerId: currentCourse.owner,
            users: currentCourse.usersEnrolled.length,
            createdAt: currentCourse.createdAt,
            isPublic: currentCourse.isPublic
        }));
    } catch(err){
        ctx.errors = err.message;
    }
    
    res.render('home', ctx);
});

module.exports = router;