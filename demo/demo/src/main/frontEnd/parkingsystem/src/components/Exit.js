import axios from "axios";
import React, { useState } from 'react';
import Popup from 'reactjs-popup';
import 'reactjs-popup/dist/index.css';

function Exit() {
  // هذا المتغير يكون فيه معلومات التكت اللي تنطبع على الشاشة
  let m ={endTime:"",id:"",price:"",startTime:0};
  const [ticket,setTicket]=useState(m);
  const[plat,setPlat]=useState(0);

  function ExitUser(event) {
    event.preventDefault();
    // setPlat(document.getElementById("platnum").value);
    setPlat(document.getElementById("platnum").value);
    console.log("in pn");
    axios
      .put(`http://localhost:8080/ticket/${plat}`)
      .then(function (response) {
        axios
          .get(`http://localhost:8080/ticket/${plat}`)
          .then(function (response) {
            setTicket(response.data);
            console.log(response.data);
            
              
          })
          .catch(function (error) {
            console.error(error);
          });
      })
      .catch(function (error) {
        console.error(error);
      });
  }
  return (
    <div className="sign-up-htm">
      <div className="group">
        <label className="label">Plat Number</label>
        <input type="text" id="platnum" name="platNum" className="input" />
      </div>
      <div className="group">
        <input
          onClick={ExitUser}
          type="submit"
          className="button"
          defaultValue="Sign Up"
        />
        <br></br>
        <Popup trigger={<button className="button">Print ticket</button>} position="bottom center">
    <div>
    <h5>Plat number:{plat}</h5>
        <h5>Entry Time:{ticket.startTime}</h5>
    <h5>Exit Time:{ticket.endTime}</h5>
    <h5>Total price:{ticket.price}</h5>
    </div>
  </Popup>
      </div>
    </div>
  );
}
export default Exit;
