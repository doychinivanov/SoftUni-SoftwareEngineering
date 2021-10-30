const homeController = require('../controllers/homeController');
const authController = require('../controllers/authController');
const profileController = require('../controllers/profileController');
const postController = require('../controllers/postController')
const errorController = require('../controllers/errorController');

module.exports = (app) => {
    app.use('/', homeController);
    app.use('/auth', authController);
    app.use('/user', profileController);
    app.use('/post', postController);
    app.use('*', errorController);
}