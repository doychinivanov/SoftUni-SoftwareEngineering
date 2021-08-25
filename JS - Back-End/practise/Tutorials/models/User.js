
const {Schema, model} = require('mongoose');

const schema = new Schema({
    username: {type: String, required: [true, 'A username is required!'], minLength: [4, 'Username must be at leas 4 characters!'], maxLength: [18, 'Username cannot exceed 18 characters!']},
    // email: {type: String, required: [true, 'An email is required!']},
    hashedPassword: {type: String, required: [true, 'Password is required!']},
    takenCourses: [{type: Schema.Types.ObjectId, ref: 'Course', default: []}],
    
});


module.exports = model('User', schema);