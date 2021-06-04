function solve() {
   document.querySelector('#searchBtn').addEventListener('click', onClick);

   function onClick() {
      const tableData = [...document.querySelectorAll('table tbody tr')];
      const searchParams = document.getElementById('searchField').value;

      tableData.forEach(data => {
         if(data.textContent.toLowerCase().includes(searchParams.toLowerCase())){
            data.classList.add('select');
         } else {
            data.classList.remove('select');
         }
      })
   }
}