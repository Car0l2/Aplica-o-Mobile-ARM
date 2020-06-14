const Colaborador = require('../models/colab.model');
const Crianca = require('../models/crianca.model');
const Registo = require('../models/registo.model');
const sequelize = require('../config/database');

const controllers = {};

//função do endpoint /colaborador

controllers.colab_list = async (req, res) => {
    const dados = await Colaborador.findAll()
        .then(function(dados) {
            return dados;
        })
        .catch(error => {
            return 'Erro no pedido de dados ao servidor ('+ error +')';
        });
    
    res.json({
        'success': true,
        'dados': dados
    });
}

controllers.colab_detail = async (req, res) => {
    const {id_colaborador} = req.params;
    const dados = await Colaborador.findAll({ where: { id_colaborador: id_colaborador }})
        .then(function(dados) {
            return dados;
        })
        .catch(error => {
            return 'Erro no pedido de dados ao servidor ('+ error +')';
        });

    res.json({
        'success': true,
        'dados': dados
    });
}

controllers.colab_create = async (req, res) => {
    const { nome_colaborador, sala, funcao, telemovel, email, pass_enc } = req.body;
    const dados = await Colaborador.create({
        'nome_colaborador': nome_colaborador,
        'sala': sala,
        'funcao': funcao,
        'telemovel': telemovel,
        'email': email,
        'pass_enc': pass_enc
        })
        .then(function(dados) {
            return dados;
        })
        .catch(error => {
            return 'Erro no pedido de dados ao servidor ('+ error +')';
        });

    res.status(201).json({
        'success': true,
        'dados': dados
    });
}

controllers.colab_update = async (req, res) => {
    const {id_colaborador} = req.params;
    const { nome_colaborador, sala, funcao, telemovel, email, pass_enc } = req.body;
    const dados = await Colaborador.update({
            'nome_colaborador': nome_colaborador,
            'sala': sala,
            'funcao': funcao,
            'telemovel': telemovel,
            'email': email,
            'pass_enc': pass_enc
        }, {
            'where': { 'id_colaborador': id_colaborador }
        })
        .then(function(dados) {
            return dados;
        })
        .catch(error => {
            return 'Erro no pedido de dados ao servidor ('+ error +')';
        });

    res.json({
        'success': true,
        'dados': dados
    });
}

controllers.colab_delete = async (req, res) => {
    const {id_colaborador} = req.params;
    const dados = await Colaborador.destroy({ where: { id_colaborador: id_colaborador } });

    res.status(204).json({
        'success': true,
        'dados': dados
    });
}

//função do endpoint /criancas

controllers.crianca_list = async (req, res) => {
    const dados = await Crianca.findAll()
        .then(function(dados) {
            return dados;
        })
        .catch(error => {
            return 'Erro no pedido de dados ao servidor ('+ error +')';
        });
    
    res.json({
        'success': true,
        'dados': dados
    });
}

controllers.crianca_detail = async (req, res) => {
    const {id_crianca} = req.params;
    const dados = await Crianca.findAll({ where: { id_crianca: id_crianca }})
        .then(function(dados) {
            return dados;
        })
        .catch(error => {
            return 'Erro no pedido de dados ao servidor ('+ error +')';
        });

    res.json({
        'success': true,
        'dados': dados
    });
}

controllers.crianca_create = async (req, res) => {
    const { nome_crianca, idade, sala, alergias, restricao, doenca_cronica, contacto, data } = req.body;
    const dados = await Crianca.create({
        'nome_crianca': nome_crianca,
        'idade': idade,
        'sala': sala,
        'alergias': alergias,
        'restricao': restricao,
        'doenca_cronica': doenca_cronica,
        'contacto': contacto,
        'data': data
        })
        .then(function(dados) {
            return dados;
        })
        .catch(error => {
            return 'Erro no pedido de dados ao servidor ('+ error +')';
        });

    res.status(201).json({
        'success': true,
        'dados': dados
    });
}

controllers.crianca_update = async (req, res) => {
    const {id_crianca} = req.params;
    const { nome_crianca, idade, sala, alergias, restricao, doenca_cronica, contacto, data } = req.body;
    const dados = await Crianca.update({
        'nome_crianca': nome_crianca,
        'idade': idade,
        'sala': sala,
        'alergias': alergias,
        'restricao': restricao,
        'doenca_cronica': doenca_cronica,
        'contacto': contacto,
        'data': data
        }, {
            'where': { 'id_crianca': id_crianca }
        })
        .then(function(dados) {
            return dados;
        })
        .catch(error => {
            return 'Erro no pedido de dados ao servidor ('+ error +')';
        });

    res.json({
        'success': true,
        'dados': dados
    });
}

controllers.crianca_delete = async (req, res) => {
    const {id_crianca} = req.params;
    const dados = await Crianca.destroy({ where: { id_crianca: id_crianca } });

    res.status(204).json({
        'success': true,
        'dados': dados
    });
}

//função do endpoint /resgisto_medicacao

controllers.registo_list = async (req, res) => {
    const dados = await Registo.findAll()
        .then(function(dados) {
            return dados;
        })
        .catch(error => {
            return 'Erro no pedido de dados ao servidor ('+ error +')';
        });
    
    res.json({
        'success': true,
        'dados': dados
    });
}

controllers.registo_detail = async (req, res) => {
    const {id_registo} = req.params;
    const dados = await Registo.findAll({ where: { id_registo: id_registo }})
        .then(function(dados) {
            return dados;
        })
        .catch(error => {
            return 'Erro no pedido de dados ao servidor ('+ error +')';
        });

    res.json({
        'success': true,
        'dados': dados
    });
}

controllers.registo_create = async (req, res) => {
    const { id_crianca, nome_med, val_med, ref_med, dose, observacao, id_colaborador, data_registo } = req.body;
    const dados = await Registo.create({
        'id_crianca': id_crianca,
        'nome_med': nome_med,
        'val_med': val_med,
        'ref_med': ref_med,
        'dose': dose,
        'observacao': observacao,
        'id_colaborador': id_colaborador,
        'data_registo': data_registo
        })
        .then(function(dados) {
            return dados;
        })
        .catch(error => {
            return 'Erro no pedido de dados ao servidor ('+ error +')';
        });

    res.status(201).json({
        'success': true,
        'dados': dados
    });
}

controllers.registo_update = async (req, res) => {
    const {id_registo} = req.params;
    const { id_crianca, nome_med, val_med, ref_med, dose, observacao, id_colaborador, data_registo } = req.body;
    const dados = await Registo.update({
        'id_crianca': id_crianca,
        'nome_med': nome_med,
        'val_med': val_med,
        'ref_med': ref_med,
        'dose': dose,
        'observacao': observacao,
        'id_colaborador': id_colaborador,
        'data_registo': data_registo
        }, {
            'where': { 'id_registo': id_registo }
        })
        .then(function(dados) {
            return dados;
        })
        .catch(error => {
            return 'Erro no pedido de dados ao servidor ('+ error +')';
        });

    res.json({
        'success': true,
        'dados': dados
    });
}

controllers.registo_delete = async (req, res) => {
    const {id_registo} = req.params;
    const dados = await Registo.destroy({ where: { id_registo: id_registo } });

    res.status(204).json({
        'success': true,
        'dados': dados
    });
}

module.exports = controllers;