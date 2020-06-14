const express = require('express');
const router = express.Router();

//importar o controlador
const armController = require('../controllers/arm.controller');

//endpoints da API

//endpoints colaboradores
router.get('/colaboradores', armController.colab_list);
router.get('/colaborador/:id_colaborador', armController.colab_detail);
router.post('/colab', armController.colab_create);
router.put('/colaborador/:id_colaborador', armController.colab_update);
router.delete('/colaborador/:id_colaborador', armController.colab_delete);

//endpoints criancas
router.get('/criancas', armController.crianca_list);
router.get('/crianca/:id_crianca', armController.crianca_detail);
router.post('/crianca', armController.crianca_create);
router.put('/crianca/:id_crianca', armController.crianca_update);
router.delete('/crianca/:id_crianca', armController.crianca_delete);

//endpoints registo_medicacao
router.get('/registos', armController.registo_list);
router.get('/registo/:id_registo', armController.registo_detail);
router.post('/registo', armController.registo_create);
router.put('/registo/:id_registo', armController.registo_update);
router.delete('/registo/:id_registo', armController.registo_delete);

module.exports = router;