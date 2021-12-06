import axios from "axios";
import React from 'react';
import Popup from 'reactjs-popup';
import 'reactjs-popup/dist/index.css';

function Exit() {
  // هذا المتغير يكون فيه معلومات التكت اللي تنطبع على الشاشة
  let ticket;

  function ExitUser(event) {
    event.preventDefault();
    let pn = document.getElementById("platNum").value;
    console.log("in pn");
    axios
      .put(`http://localhost:8080/ticket/${pn}`)
      .then(function (response) {
        axios
          .get(`http://localhost:8080/ticket/${pn}`)
          .then(function (response) {
            ticket = response.data;
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
      </div>
    </div>
  );
}
export default Exit;
