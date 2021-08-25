const User = require('../models/User');

async function createUser(username, hashedPassword,){
    console.log(username)
    const user = new User({
        username,
        hashedPassword,
        takenCourses: []
    });

    await user.save();

    return user;
};

async function getUserByUsername(username){
    const pattern = new RegExp(`^${username}$`, 'i');
    const user = await User.findOne({username: {$regex: pattern}}).lean();

    return user;
};

async function getUserById(id){
    const user = await User.findById(id);

    return user;
}


async function getAllUsersContainingUsername(username){
    const pattern = new RegExp(username, 'i');
    const users = await User.find({username: {$regex: pattern}});

    return users;
};

async function getUserByEmail(email){
    const pattern = new RegExp(`^${email}$`, 'i')
    const user = await User.findOne({email: {$regex: pattern}});

    return user;
};

async function joinCourse(userId, courseId){
    const user = await User.findById(userId);

    user.takenCourses.push(courseId);
    user.save();
}


module.exports = {
    createUser,
    getUserByUsername,
    getUserById,
    getUserByEmail,
    getAllUsersContainingUsername,
    joinCourse
}