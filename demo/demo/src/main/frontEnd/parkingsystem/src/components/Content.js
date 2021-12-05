import { Col, Row, Nav, Form,  } from "react-bootstrap";
function Content(){



    return(
        < >
        <Col sm={9}>
              <div className="register-right">
                <ul>
                  {" "}
                  <Nav
                    variant="tabs"
                    className="nav nav-tabs nav-justified"
                    id="myTab"
                    role="tablist"
                  >
                    <li>
                      {" "}
                      <Nav.Item>
                        <Nav.Link
                          className="nav-link active"
                          id="home-tab"
                          data-toggle="tab"
                          href="#home"
                          role="tab"
                          aria-controls="home"
                          aria-selected="true"
                        >
                          Employee
                        </Nav.Link>
                      </Nav.Item>{" "}
                    </li>

                    <li>
                      {" "}
                      <Nav.Item>
                        <Nav.Link
                          id="profile-tab"
                          data-toggle="tab"
                          href="#profile"
                          role="tab"
                          aria-controls="profile"
                          aria-selected="false"
                        >
                          Hirer
                        </Nav.Link>
                      </Nav.Item>
                    </li>
                  </Nav>
                </ul>

                <div className="tab-content" id="myTabContent">
                  <div
                    className="tab-pane fade show active"
                    id="home"
                    role="tabpanel"
                    aria-labelledby="home-tab"
                  >
                    <h3 className="register-heading">Apply as a Employee</h3>

                    <div className=" register-form">
                      <Row>
                        <Col sm={6}>
                          <Form.Group controlId="formBasicText">
                            <Form.Control
                              type="text"
                              placeholder="First Name"
                            />
                          </Form.Group>
                          <Form.Group controlId="formBasicText">
                            <Form.Control type="text" placeholder="Last Name" />
                          </Form.Group>

                          <Form.Group
                            className="mb-3"
                            controlId="formBasicCheckbox"
                          >
                            <div className="maxl">
                              <Form.Check
                                inline
                                label="1"
                                name="group1"
                                type="radio"
                                id={`inline-"radio"-1`}
                              />
                              <Form.Check
                                inline
                                label="2"
                                name="group1"
                                type="radio"
                                id={`inline-"radio"-2`}
                              />
                            </div>
                          </Form.Group>
                        </Col>
                        <Col sm={6}>
                          <Form.Group controlId="formBasicEmail">
                            <Form.Control
                              type="email"
                              placeholder="Enter email"
                            />
                            <Form.Control
                              type="text"
                              placeholder="Your Phone"
                            //   minlength="10"
                            //   maxlength="10"
                              name="txtEmpPhone"
                            />
                          </Form.Group>
                          <input
                            type="submit"
                            className="btnRegister"
                            
                          />
                        </Col>
                      </Row>
                    </div>
                  </div>

                  <div
                    className="tab-pane fade show"
                    id="profile"
                    role="tabpanel"
                    aria-labelledby="profile-tab"
                  >
                    <h3 className="register-heading">Apply as a Hirer</h3>
                    <div className="row register-form">

                      <div className="col-md-6">
                         <div className="form-group">
                          <input
                            type="text"
                            className="form-control"
                            placeholder="First Name *"
                            
                          />
                         </div>
                        <div className="form-group">
                          <input
                            type="text"
                            className="form-control"
                            placeholder="Last Name *"
                           
                          />
                        </div>
                        <div className="form-group">
                          <input
                            type="email"
                            className="form-control"
                            placeholder="Email *"
                          
                          />
                        </div>
                        <div className="form-group">
                          <input
                            type="text"
                           
                            className="form-control"
                            placeholder="Phone *"
                            value=""
                          />
                        </div>
                      </div>
                      <div className="col-md-6">
                        <div className="form-group">
                          <input
                            type="password"
                            className="form-control"
                            placeholder="Password *"
                          
                          />
                        </div>
                        <div className="form-group">
                          <input
                            type="password"
                            className="form-control"
                            placeholder="Confirm Password *"
                         
                          />
                        </div>
                        <div className="form-group">
                          <select className="form-control">
                            <option className="hidden" selected disabled>
                              Please select your Sequrity Question
                            </option>
                            <option>What is your Birthdate?</option>
                            <option>What is Your old Phone Number</option>
                            <option>What is your Pet Name?</option>
                          </select>
                        </div>
                        <div className="form-group">
                          <input
                            type="text"
                            className="form-control"
                            placeholder="`Answer *"
                          
                          />
                        </div>
                        <input
                          type="submit"
                          className="btnRegister"
                   
                        />
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </Col>
          </>
    )
}
export default Content;