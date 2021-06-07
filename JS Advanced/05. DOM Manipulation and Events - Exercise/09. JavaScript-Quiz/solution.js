function solve() {
  const correctAnswers = ['onclick', 'JSON.stringify()','A programming API for HTML and XML documents'];
  const sections = Array.from(document.querySelectorAll('section'));
  let score = 0;
  let index = 0;

  document.getElementById('quizzie').addEventListener('click', (ev)=>{
    if(ev.target.classList.contains('answer-wrap') || ev.target.classList.contains('answer-text')){
      const answer = ev.target.textContent.trim();
      
      if(answer == correctAnswers[index]){
        score++;
      }
      
      sections[index].style.display = 'none';
      
      if(sections.length > index + 1){
        sections[index+1].style.display = 'block';
      }
      
      index++;

      if(sections[index] == undefined){
        document.querySelector("#results").style.display = "block";
        if (score !== 3) {
          document.querySelector("#results h1").textContent = `You have ${score} right answers`;
        } else {
          document.querySelector("#results h1").textContent = "You are recognized as top JavaScript fan!";
        }
      }      
    }
  });

}
