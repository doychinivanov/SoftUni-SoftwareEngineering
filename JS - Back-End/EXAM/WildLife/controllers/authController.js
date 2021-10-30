const router = require('express').Router();
const {body, validationResult} = require('express-validator');
const {errorParser} = require('../utils/errorParser');
const {isGuest, isUser} = require('../middlewares/guards');

router.get('/register', isGuest(), (req, res) => {
    const ctx = {};
    ctx.title = 'Register Page';

    res.render('authViews/register', ctx);
});

router.post('/register', isGuest(),
body('firstName').isLength({min:3}).withMessage('First Name must be at least 3 characters!').bail().isAlpha().withMessage('First name must contain only letters from the English alphabet!'),
body('lastName').isLength({min:5}).withMessage('Last Name must be at least 5 characters!').bail().isAlpha().withMessage('Last name must contain only letters from the English alphabet!'),
body('email').isEmail().withMessage('Please enter a valid email!'),
body('password').isLength({min: 4}).withMessage('Password must be at least 4 characters long!').bail(),
body('rePass').custom((value, {req})=>{if(value != req.body.password){throw new Error('Passwords don\'t match!')} return true}),
async (req, res) => {
    const {errors} = validationResult(req);

    const userData = {
        firstName: req.body.firstName.trim(),
        lastName: req.body.lastName.trim(),
        email: req.body.email.trim(),
        password: req.body.password.trim() 
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


router.get('/login', isGuest(), (req, res) => {
    const ctx = {};
    ctx.title = 'Login Page';
    
    res.render('authViews/login', ctx);
});

router.post('/login', isGuest(),
body('email').notEmpty().withMessage('No empty fields are allowed!').bail(),
body('password').notEmpty().withMessage('No empty fields are allowed!'),
async (req, res) => {
    const {errors} = validationResult(req);

    try{
        if(errors.length > 0){
            throw new Error(Object.values(errors).map(e => e.msg).join('\n'));
        }

        await req.auth.login(req.body.email.trim(), req.body.password.trim());
        res.redirect('/');
    } catch(err){
        const ctx = {
            errors: errorParser(err),
            userData: {
                email: req.body.email.trim()
            }
        };

        res.render('authViews/login', ctx);
    }
});

router.get('/logout', isUser(), (req, res) => {
    req.auth.logout();
    res.redirect('/');
});


module.exports = router;