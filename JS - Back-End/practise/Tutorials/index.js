const express = require('express');
const databaseConfig = require('./config/databaseConfig');
const expressConfig = require('./config/expressConfig');
const router = require('./config/routes');

startApp();

async function startApp(){
    const app = express();
    await databaseConfig(app);
    expressConfig(app);
    router(app);

    app.listen(3000, ()=> console.log(`Server listening on port 3000...`));
}