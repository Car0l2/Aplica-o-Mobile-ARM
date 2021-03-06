import React, { Component } from "react";
import { Container, Button, Form, FormGroup, Label, Input } from "reactstrap";

class NovoAluno extends Component {
  render() {
    return (
        <Container>
            <h1>Formulário de criação de um novo aluno</h1>
            <Form responsive>
                <FormGroup row>
                    <Label for="nome" size="lg">Nome:</Label>
                    <Input type="text" name="nome" id="nome" bsSize="lg" />
                </FormGroup>
                <FormGroup row>
                    <Label for="email" size="lg">Email:</Label>
                    <Input type="email" name="email" id="email" bsSize="lg" />
                </FormGroup>
                <FormGroup row>
                    <Label for="morada" size="lg">Morada:</Label>
                    <Input type="text" name="morada" id="morada" bsSize="lg" />
                </FormGroup>
                <FormGroup row>
                    <Label for="telefone" size="lg">Telefone:</Label>
                    <Input type="number" name="telefone" id="telefone" bsSize="lg" />
                </FormGroup>
                <Button color="primary" size="lg" onClick={ () => this.criaAluno() }>Novo Aluno</Button>
            </Form>
        </Container>
    );
  }
}

export default NovoAluno;