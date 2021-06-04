function solve() {
   document.querySelector('#btnSend').addEventListener('click', onClick);
   let textInput = document.querySelector('.restaurant-race-class>#inputs>textarea');
   const bestRestaurantOutput = document.querySelector('#bestRestaurant>p');
   const bestWorkersOutput = document.querySelector('#workers>p')

   function onClick () {
      const restaurantObject = {};
      const dataArr = JSON.parse(textInput.value);

      setRestaurants(dataArr, restaurantObject);
      const bestRestaurant = findBestRestaurant(restaurantObject);
      
      const result = [];
      bestRestaurant.workers.forEach(worker => {
         result.push(`Name: ${worker.name} With Salary: ${worker.salary}`)
      });

      bestRestaurantOutput.textContent = `Name: ${bestRestaurant.name} Average Salary: ${bestRestaurant.averageSalary.toFixed(2)} Best Salary: ${bestRestaurant.bestSalary.toFixed(2)}`
      bestWorkersOutput.textContent = result.join(' ');
   }


   function setRestaurants(dataArr, restaurantObject){
      dataArr.forEach(line => {
         let [restaurant, params] = line.split(' - ');
         const workersArr = params.split(', ');
         let workers = [];
         let averageSalary = 0;
         let bestSalary = 0;
         
         workersArr.forEach(worker=>{
            let [workerName, salary] = worker.split(' ');
            workers.push({name:workerName, salary: Number(salary)})
         })

         if(restaurantObject.hasOwnProperty(restaurant)){
            workers = workers.concat(restaurantObject[restaurant].workers);
         }

         workers.sort((workerA, workerB) => workerB.salary - workerA.salary);
         bestSalary = workers[0].salary;
         averageSalary = (workers.reduce((acc, cur) => acc + cur.salary, 0)/workers.length).toFixed(2);
         
         restaurantObject[restaurant] = {
            workers,
            averageSalary : Number(averageSalary),
            bestSalary
         }
      });
   }

   function findBestRestaurant(restaurantObject){
      let bestRestaurantSalary = 0;
      let bestRestaurant = undefined;

      for (const name in restaurantObject) {
         if(restaurantObject[name].averageSalary > bestRestaurantSalary){
            bestRestaurant = {
               name,
               workers: restaurantObject[name].workers,
               bestSalary: restaurantObject[name].bestSalary,
               averageSalary: restaurantObject[name].averageSalary
            }
         }

         bestRestaurantSalary = restaurantObject[name].averageSalary;
      }

      return bestRestaurant;

   }
}