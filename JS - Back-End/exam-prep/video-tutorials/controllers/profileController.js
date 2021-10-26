const router = require('express').Router();
const userService = require('../services/userService');
const {isGuest, isUser} = require('../middlewares/guards');

router.get('/profile', isUser(), async(req,res)=>{
    const user = await userService.getUserById(req.user._id);

    const ctx = {
        userData: {...req.user, enrolledCourses: user.enrolledCourses.map(x => x.title)},
        title: 'Profle Page'
    }

    res.render('authViews/profile', ctx);
});

module.exports = router;