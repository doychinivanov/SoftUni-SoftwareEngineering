function solve() {

  const input = document.getElementById("text").value.split(" ").map(x=>x.toLowerCase());
  const convention = document.getElementById('naming-convention').value;

  if(convention != 'Pascal Case' && convention != 'Camel Case'){
    document.getElementById("result").textContent = 'Error!'
  } else {
    document.getElementById("result").textContent = transformToCase(convention, input);
  }


  function transformToCase(neededCase, inputArr){
    const cases = {
      'Pascal Case':(inputArr)=>{
        let result = '';
        inputArr.forEach(word => {
          const firstLetter = word[0].toUpperCase();
          word = firstLetter + word.substring(1);
          result += word;
        });
  
        return result;
      },
      'Camel Case':(inputArr)=>{
        let result = inputArr.shift();
        inputArr.forEach(word => {
          const firstLetter = word[0].toUpperCase();
          word = firstLetter + word.substring(1);
          result += word;
        });
  
        return result;
      }
    }

    return cases[neededCase](inputArr);
  }
}