const router = require('express').Router();

router.get('/', async (req,res)=>{
    const ctx = {};
    ctx.title = 'Home Page';

    res.render('home', ctx);
});

module.exports = router;