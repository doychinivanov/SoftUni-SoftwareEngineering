const {Schema, model} = require('mongoose');

const schema = new Schema({
    title: {type: String, required: [true, 'A course title name is required!']},
    description: {type: String, required: [true, 'A course description is required!'], maxlength:[50, 'Max length of description must be 50 symbols.']},
    imageUrl: {type: String, required: [true, 'Image is required!']},
    duration: {type: String, required: [true, 'Set the duration of your course.']},
    enrolledUsers: [{type: Schema.Types.ObjectId, ref: 'User', default: []}],
    createdAt: {type: Date, default: Date.now},
    owner: {type: Schema.Types.ObjectId, ref: 'User'}
});


module.exports = model('Course', schema);