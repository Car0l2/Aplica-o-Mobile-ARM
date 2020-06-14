const sequelize = require('sequelize');
const db = require('../config/database');


var Crianca = db.define('criancas', {
    id_crianca: {
        type: sequelize.INTEGER, primaryKey: true,
        autoIncrement: true
    },
    nome_crianca: sequelize.STRING,
    idade: sequelize.BIGINT,
    sala: sequelize.STRING,
    alergias: sequelize.STRING,
    restricao: sequelize.STRING,
    doenca_cronica: sequelize.STRING,
    contacto: sequelize.BIGINT,
    data:  {
        type: sequelize.DATE, 
        timestamps: true
    }
}, {
    timestamps: false,
    tableName: 'criancas'
});



module.exports = Crianca;
