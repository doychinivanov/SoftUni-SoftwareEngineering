const express = require('express');
const databaseConfig = require('./config/databaseConfig');
const expressConfig = require('./config/expressConfig');
const router = require('./config/routes');
const {PORT} = require('./config/index');

startApp();

async function startApp(){
    const app = express();
    await databaseConfig(app);
    expressConfig(app);
    router(app);

    app.listen(PORT, ()=> console.log(`Server listening on port ${PORT}...`));
}