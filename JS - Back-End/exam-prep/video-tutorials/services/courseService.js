const Course = require('../models/Course');

async function createCourse(courseData){
    const course = new Course({
        title: courseData.title,
        description: courseData.description,
        imageUrl: courseData.imageUrl,
        usersEnrolled: [],
        owner: courseData.ownerId,
        isPublic: courseData.isPublic
    });

    await course.save();

    return course;
};

async function getAllCourses(){
    const courses = await Course.find({});

    return courses;
}

// async function getAllCoursesSortedByParticipants(query=''){
//     const pattern = new RegExp(query, 'i');
//     const courses = await Course.find({title: {$regex: pattern}}).sort({'usersEnrolled': 'desc'});

//     return courses;
// }

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

    course.usersEnrolled.push(userId)

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
    // getAllCoursesSortedByParticipants,
    addParticipant,
    getAllCourses
};