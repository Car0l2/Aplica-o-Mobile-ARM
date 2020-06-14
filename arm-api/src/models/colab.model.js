const sequelize = require('sequelize');
const db = require('../config/database');

var Colaborador = db.define('colaboradores', {
    id_colaborador: {
        type: sequelize.INTEGER, primaryKey: true,
        autoIncrement: true
    },
    nome_colaborador: sequelize.STRING,
    sala: sequelize.STRING,
    funcao: sequelize.STRING,
    telemovel: sequelize.BIGINT,
    email: sequelize.STRING,
    pass_enc: sequelize.STRING
}, {
    timestamps: false,
    tableName: 'colaboradores'
});
module.exports = Colaborador;

