const router = require('express').Router();

router.get('/', async (req,res)=>{
    const query = req.query.courseName;
    const ctx = {}
    ctx.user = req.user;

    try{
        const courses = await req.storage.getAllCoursesSortedByParticipants(query);
        ctx.courses = courses.map(currentCourse => ({
            _id: currentCourse._id,
            title: currentCourse.title,
            description: currentCourse.description,
            imageUrl: currentCourse.imageUrl,
            duration: currentCourse.duration,
            ownerId: currentCourse.owner,
            users: currentCourse.enrolledUsers.length,
            createdAt: currentCourse.createdAt
        }));
    } catch(err){
        ctx.errors = err.message;
    }
    
    res.render('home', ctx);
});

module.exports = router;