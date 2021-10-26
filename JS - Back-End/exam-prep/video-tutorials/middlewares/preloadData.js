function preloadCourses() {
    return async (req, res, next) => {
        req.data = req.data || {};

        if(req.user){
            try {
                const courses = await req.storage.getCoursesByAuthorId(req.user._id);

                if (courses) {
                    req.data.currentUsersCourses = courses.map(x => x._id);
                };
    
            } catch (err){
                console.error('Database error: ', err.message)
            }
        }

        next();
    }
}

module.exports = {preloadCourses};