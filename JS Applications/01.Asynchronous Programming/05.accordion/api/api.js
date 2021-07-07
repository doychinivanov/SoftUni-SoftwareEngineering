export async function getArticleTitles(){
    try{
        const data = await fetch('http://localhost:3030/jsonstore/advanced/articles/list');
        const result = await data.json();

        return result;
    }catch(err){
        alert(err.message);
        return;
    }
};

export async function getArticleData(id){
    try{
        const result = await fetch('http://localhost:3030/jsonstore/advanced/articles/details/' + id);
        const data = await result.json();

        return data;
    }catch(err){
        alert(err.message);
        return;
    }
}