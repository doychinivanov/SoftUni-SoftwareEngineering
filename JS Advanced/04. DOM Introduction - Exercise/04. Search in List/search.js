function search() {
   const towns = [...document.querySelectorAll('#towns li')];
   const searchParams = document.getElementById('searchText').value;

   towns.forEach(town=>{
      if(town.textContent.toLowerCase().includes(searchParams.toLowerCase())){
         town.style.fontWeight = 'bold';
         town.style.textDecoration = 'underline';
      } else {
         town.style.fontWeight = '';
         town.style.textDecoration = 'none';
      }
   })

   const matchesAmount = towns.filter(x => x.textContent.toLowerCase().includes(searchParams.toLowerCase())).length;
   document.getElementById('result').textContent = `${matchesAmount} matches found`
}
