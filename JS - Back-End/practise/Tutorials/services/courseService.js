const Course = require('../models/Course');

async function createCourse(hotelData){
    const course = new Course({
        title: hotelData.title,
        description: hotelData.description,
        imageUrl: hotelData.imageUrl,
        duration: hotelData.duration,
        enrolledUsers: [],
        owner: hotelData.ownerId
    });

    await course.save();

    return course;
};

async function getAllCoursesSortedByParticipants(query=''){
    const pattern = new RegExp(query, 'i');
    const courses = await Course.find({title: {$regex: pattern}}).sort({'enrolledUsers': 'desc'});

    return courses;
}

async function getCourseById(id){
    const course = await Course.findById(id);

    return course;
}

async function getCoursesByAuthorId(id){
    const courses = await Course.find({'owner': id});

    return courses;
};

async function editCourse(id, courseData){
    const course = await Course.findById(id);

    course.title = courseData.title;
    course.description = courseData.description;
    course.duration = courseData.duration;
    course.imageUrl = courseData.imageUrl;

    return course.save();
}

async function addParticipant(courseId, userId){
    const course = await Course.findById(courseId);

    course.enrolledUsers.push(userId)

    return course.save();
}

async function deleteCourse(id){
    return await Course.findByIdAndDelete(id);
}

module.exports = {
    createCourse,
    deleteCourse,
    editCourse,
    getCoursesByAuthorId,
    getCourseById,
    getAllCoursesSortedByParticipants,
    addParticipant
};