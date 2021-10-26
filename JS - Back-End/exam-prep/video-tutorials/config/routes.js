const homeController = require('../controllers/homeController');
const authController = require('../controllers/authController');
const profileController = require('../controllers/profileController');
const courseController = require('../controllers/courseController')

module.exports = (app) => {
    app.use('/', homeController);
    app.use('/auth', authController);
    app.use('/user', profileController);
    app.use('/course', courseController);
}