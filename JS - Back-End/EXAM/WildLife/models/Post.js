const {Schema, model} = require('mongoose');

const schema = new Schema({
    title: {type: String, required: [true, 'A post title name is required!']},
    keyword: {type: String, required: [true, 'A post must have a keyword!']},
    location: {type: String, required:[true, 'Location is required!']},
    date: {type: String, required:[true, 'Date of creation is required!']},
    imageUrl: {type: String, required: [true, 'Image is required!']},
    description: {type: String, required: [true, 'A post description is required!']},
    author: {type: Schema.Types.ObjectId, ref: 'User'},
    voters: [{type: Schema.Types.ObjectId, ref: 'User', default: []}],
    rating: {type: Number, default: 0}
});


module.exports = model('Post', schema);