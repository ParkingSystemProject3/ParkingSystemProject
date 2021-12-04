import { Col, Container, Row,Form,Navbar} from "react-bootstrap";
import { Link } from "react-router-dom";
function Login (){
    return(
        <div className ="pageLogin">
          <Container>
        <section id="formHolder">
        <Row>
            {/* <!-- Brand Box --> */}
            <Col sm={6}>
            <div className="brand">
            
            
              <div className="heading">
                <h2>BarkSystem</h2>
                
              </div>

              {/* <div className="success-msg">
                <p>Great! You are one of our members now</p>
                <a href="#" className="profile">
                  Your Profile
                </a>
              </div> */}
              </div>
              </Col >

            {/* <!-- Form Box --> */}
            <Col sm={6}>
            <div className="form">

              {/* <!-- Signup Form --> */}
              <div className="signup form-peice">
              <form className="login-form" action="/home" method="post">
              <Form.Group controlId="formBasicEmail">
                            <Form.Control
                              type="email"
                              placeholder="Enter email"
                              name="loginemail"
                              id="loginemail"
                              required
                            />
                           </Form.Group>    
                           <Form.Group controlId="formBasicPassword">
                            <Form.Control
                             type="password"
                             placeholder="Enter Password"
                             name="loginPassword"
                             id="loginPassword"
                             required
                            />
                           </Form.Group>  
                  

                  <div className="CTA">
                    <input type="submit" value="Login"  />
                  </div>
                  
                </form>
              </div>
              {/* -- End Signup Form */}
            </div>
            </Col >
            </Row>
        </section>

      </Container>
            

        </div>
    )
}
export default Login;