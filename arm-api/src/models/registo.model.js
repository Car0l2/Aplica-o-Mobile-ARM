const sequelize = require('sequelize');
const db = require('../config/database');


var Registo = db.define('registo_medicacao', {
    id_registo: {
        type: sequelize.INTEGER, primaryKey: true,
        autoIncrement: true
    },
    id_crianca: {
        type: sequelize.INTEGER, foreignKey: true,
        autoIncrement: false
    },
    nome_med: sequelize.STRING,
    val_med: sequelize.DATE,
    ref_med: sequelize.BIGINT,
    dose: sequelize.STRING,
    observacao: sequelize.STRING,
    id_colaborador:{
        type: sequelize.INTEGER, foreignKey: true,
        autoIncrement: false
    },
    data_registo: {
        type: sequelize.DATE, 
        timestamps: true
    }
}, {
    timestamps: false,
    tableName: 'registo_medicacao'
});



module.exports = Registo;
