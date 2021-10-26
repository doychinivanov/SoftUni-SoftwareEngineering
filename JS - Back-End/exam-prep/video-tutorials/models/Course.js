const {Schema, model} = require('mongoose');

const schema = new Schema({
    title: {type: String, required: [true, 'A course title name is required!'], minlength:[4, 'The title should be at least 4 characters long.']},
    description: {type: String, required: [true, 'A course description is required!'], minlength:[20, 'The description should be at least 20 characters long.']},
    imageUrl: {type: String, required: [true, 'Image is required!']},
    // duration: {type: String, required: [true, 'Set the duration of your course.']},
    usersEnrolled: [{type: Schema.Types.ObjectId, ref: 'User', default: []}],
    createdAt: {type: Date, default: Date.now},
    owner: {type: Schema.Types.ObjectId, ref: 'User'},
    isPublic: {type: Boolean, default: false}
});


module.exports = model('Course', schema);