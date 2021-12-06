import axios from "axios";
import React, { useState } from 'react';
import Popup from 'reactjs-popup';
import 'reactjs-popup/dist/index.css';
import { useModal } from 'react-hooks-use-modal';


function Entry() {
  const [Modal, open, close, isOpen] = useModal('root', {
    preventScroll: true,
    closeOnOverlayClick: false
  });
  let slotType;
  const[id,setId]=useState(0);

  function getSpot() {
    console.log("in");
    if (slotType == "normal") {
      console.log("inin");
      axios
        .get("http://localhost:8080/spot/normal")
        .then(function (response) {
          setId(response.data.id);
        })
        .catch(function (error) {
          console.error(error);
        });
    } else {
      axios
        .get("http://localhost:8080/spot/not_normal")
        .then(function (response) {
          setId(response.data.id);
        })
        .catch(function (error) {
          console.error(error);
        });
    }
  }
  function addUser(event) {
    console.log("d");
    event.preventDefault();
    let user = {
      fName: "",
      lName: "",
      platNumber: 0,
      phone: 0,
      spot: { id: 0 },
    };
    user.fName = document.getElementById("fname").value;
    user.lName = document.getElementById("lname").value;
    user.platNumber = document.getElementById("platnum").value;
    user.phone = document.getElementById("number").value;
    user.spot.id = document.getElementById("spotId").value;

    axios
      .post("http://localhost:8080/users", user)
      .then(function (response) {
        console.log("vf");
      })
      .catch(function (error) {
        console.error(error);
      });
      open();
  }

  return (
    <div className="sign-in-htm">
      <div className="group">
        <label className="label">normal</label>
        <input
          type="radio"
          id="Special Needs"
          name="Special Needs"
          onClick={() => {
            slotType = "normal";
            getSpot();
          }}
          value="Special Needs"
        />
      </div>
      <div className="group">
        <label className="label">Special Needs</label>
        <input
          type="radio"
          id="Special Needs"
          name="Special Needs"
          value="Special Needs"
          onClick={() => {
            slotType = "Notnormal";
            getSpot();
          }}
        />
      </div>
      <div className="group">
        <Popup trigger={<button
          className="button"
          defaultValue="Sign In"
        >submit</button>} position="right center">
    <div>
    <h5>{id} spot is empty</h5>
    </div>
  </Popup>
      </div>
      <br></br>
        
      <div className="group">
        <label className="label">First name</label>
        <input type="text" id="fname" className="input" />
      </div>
      <div className="group">
        <label className="label">Last name</label>
        <input type="text" id="lname" className="input" />
      </div>
      <div className="group">
        <label className="label">Plat Number</label>
        <input type="text" id="platnum" className="input" />
      </div>
      <div className="group">
        <label className="label">phone Number</label>
        <input type="text" id="number" className="input" />
      </div>

      <div className="group">
        <label className="label">spot-Id</label>
        <input type="text" id="spotId" className="input" />
      </div>
      <div className="group">
        <button
          onClick={addUser}
          className="button"
          defaultValue="Sign In"
        >submit</button>
         <Modal>
        <div id="color">
          <h1>successfully added </h1>
          <button className="buttonPop" onClick={close}>CLOSE</button>
        </div>
      </Modal>
      </div>
    </div>
  );
}
export default Entry;
