function isUser(){
    return (req, res, next)=>{
        if(req.user){
            next();
        } else {
            res.redirect('/auth/login');
        }
    }
};

function isGuest(){
    return (req, res, next)=>{
        if(!req.user){
            next();
        } else {
            res.redirect('/');
        }
    }
};

function isOwner(){
    return (req, res, next)=>{
        if(req.user && req.data.currentUsersCourses && req.data.currentUsersCourses.find(x => x == req.params.id)){
            next();
        } else {
            res.redirect('/');
        }
    }
};

function isNotOwner(){
    return (req, res, next)=>{
        if(req.user && req.data.currentUsersCourses && req.data.currentUsersCourses.find(x => x == req.params.id) == undefined){
            next();
        } else {
            console.log('fail')
            res.redirect('/');
        }
    }
}

module.exports = {
    isUser,
    isGuest,
    isOwner,
    isNotOwner
}