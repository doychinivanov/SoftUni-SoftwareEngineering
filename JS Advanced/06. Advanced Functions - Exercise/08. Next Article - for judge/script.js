function getArticleGenerator(articles) {
    let index = 0;
    const holder = document.getElementById('content');
    return generateArticles;

    function generateArticles() {
        if(index < articles.length){
            const newArticle = document.createElement('article');
            newArticle.textContent = articles[index];

            holder.appendChild(newArticle);
            index++;
        }
    }
}