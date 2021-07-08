export async function getAllPosts(){
    try{
        const response = await fetch('http://localhost:3030/jsonstore/blog/posts');
        const data = await response.json();
        
        return data;
    }catch(err){
        return 'Error';
    }
}

export async function getCommnets(){
    try{
        const response = await fetch('http://localhost:3030/jsonstore/blog/comments');
        const data = await response.json();
        
        return data;
    }catch(err){
        return 'Error';
    }
}

export async function getPostById(id){
    try{
        const response = await fetch('http://localhost:3030/jsonstore/blog/posts/' + id);
        const data = await response.json();
        
        return data;
    }catch(err){
        return 'Error';
    }
}