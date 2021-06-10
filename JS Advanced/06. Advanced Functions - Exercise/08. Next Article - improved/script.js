function getArticleGenerator(articles) {
    let index = 0;
    const holder = document.getElementById('content');
    return generateArticles;

    function generateArticles(ev) {
        const newArticle = document.createElement('article');

        if(index < articles.length){
            newArticle.textContent = articles[index];
            index++;
        } else {
            newArticle.textContent = "No more articles!";
            document.querySelector('button').disabled = true;
        }

        holder.appendChild(newArticle);
    }
}