const sequelize = require('sequelize');
const ligacao = new sequelize('mediregisto', 'root', '', {
    host: 'localhost',
    dialect: 'mysql'
});
module.exports = ligacao;