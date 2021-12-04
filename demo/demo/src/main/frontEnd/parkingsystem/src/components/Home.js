import { Col, Container, Row, Nav, Form, signup, form } from "react-bootstrap";

import LogOut from './LogOut'
import Content from './Content'
function Home() {
  return (
    <div className="home">
      
        <div className="register">
          <Row>
             <LogOut/>
              <Content/>
           
          </Row>
        </div>
    </div>
  );
}
export default Home;
