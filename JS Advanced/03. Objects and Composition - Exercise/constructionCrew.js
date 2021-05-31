function constructionWorkers(worker){
    if(worker.dizziness == true){
        worker.levelOfHydrated += worker.weight * 0.1 * worker.experience;
        worker.dizziness = false;
    }

    return worker;
}

console.log(constructionWorkers({ weight: 120,
    experience: 20,
    levelOfHydrated: 200,
    dizziness: true }
  ));