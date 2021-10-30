const User = require('../models/User');

async function createUser(firstName, lastName, email, hashedPassword,){
    const user = new User({
        firstName,
        lastName,
        email,
        hashedPassword,
        posts: []
    });

    return user.save();
};

async function getUserById(id){
    const user = await User.findById(id);

    return user;
}


async function getUserByEmail(email){
    const pattern = new RegExp(`^${email}$`, 'i')
    const user = await User.findOne({email: {$regex: pattern}});

    return user;
};


module.exports = {
    createUser,
    getUserById,
    getUserByEmail,
}