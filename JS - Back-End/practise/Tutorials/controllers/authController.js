const router = require('express').Router();
const {body, validationResult} = require('express-validator');
const {errorParser} = require('../utils/errorParser');
const {isGuest, isUser} = require('../middlewares/guards');

router.post('/register', isGuest(),
body('username').isLength({min:5}).withMessage('Username must be at least 5 characters!').bail().isAlphanumeric().withMessage('Username must contain only digits and letters from the English alphabet!'),
body('password').isLength({min: 3}).withMessage('Password must be at least 5 characters long!').bail().isAlphanumeric().withMessage('Passowrd cannot contain special characters!'),
body('rePassword').custom((value, {req})=>{if(value != req.body.password){throw new Error('Passwords don\'t match!')} return true}),
async (req, res) => {
    const {errors} = validationResult(req);

    const userData = {
        username: req.body.username.trim(),
        password: req.body.password.trim(),
    };

    try{
        if(errors.length > 0){
            throw new Error(Object.values(errors).map(e => e.msg).join('\n'));
        }
        
        await req.auth.register(userData);

        res.redirect('/');
    } catch(err){
        const ctx = {
            errors: errorParser(err),
            userData
        };

        res.render('authViews/register', ctx);
    }
});

router.get('/register', isGuest(), (req, res) => {
    res.render('authViews/register');
});

router.post('/login', isGuest(),
body('username').notEmpty().withMessage('All fields are required!').bail(),
body('password').notEmpty().withMessage('All fields are required!'),
async (req, res) => {
    const {errors} = validationResult(req);

    try{
        if(errors.length > 0){
            throw new Error(Object.values(errors).map(e => e.msg).join('\n'));
        }

        await req.auth.login(req.body.username.trim(), req.body.password.trim());
        res.redirect('/');
    } catch(err){
        const ctx = {
            errors: errorParser(err),
            userData: {
                username: req.body.username
            }
        };

        res.render('authViews/login', ctx);
    }
});

router.get('/login', isGuest(), (req, res) => {
    res.render('authViews/login');
});

router.get('/logout', isUser(), (req, res) => {
    req.auth.logout();
    res.redirect('/');
});

module.exports = router;