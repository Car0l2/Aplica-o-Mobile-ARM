import React, { useState } from 'react';
import logo from './logo.svg';
import './App.css';
import ListaAlunos from './Views/colaborador/list';
import NovoAluno from './Views/colaborador/create';
import EditaAluno from './Views/colaborador/edit';
import {BrowserRouter as Router, Route, Link} from 'react-router-dom';
import { Collapse, Navbar, NavbarToggler, NavbarBrand, Nav, NavItem, NavLink } from 'reactstrap';

function App() {
  const [collapsed, setCollapsed] = useState(true);
  const toggleNavbar = () => setCollapsed(!collapsed);

  return (
    <Router>
      <div>
        <Navbar color="primary" dark light>
          <NavbarBrand href="/" className="mr-auto">Programação III - React (front-end) + Node (back-end)</NavbarBrand>
          <NavbarToggler onClick={toggleNavbar} className="mr-2" />
          <Collapse isOpen={!collapsed} navbar>
            <Nav navbar>
              <NavItem>
                <NavLink href="/" className="text-white" active>Lista de Alunos</NavLink>
              </NavItem>
              <NavItem>
                <NavLink href="/create" className="text-white">Criar novo aluno</NavLink>
              </NavItem>
            </Nav>
          </Collapse>
        </Navbar>
      </div>
      <div className="App">
        <Route path="/" exact component={ListaAlunos} />
        <Route path="/create" component={NovoAluno} />
        <Route path="/edit/:id" component={EditaAluno} />
      </div>
    </Router>
  );
}

export default App;
