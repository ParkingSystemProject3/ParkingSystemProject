import axios from "axios";

 function Entry(){
     let slotType;
function getSpot(){
    if (slotType=="normal"){
        axios.get("localhost:8080/spot/normal")
        .then(function (response) {   
     console.log(response.data);       
         })    
           .catch(function (error) {    
               
            console.error(error);      });
    }
   
    else{
        axios.get("localhost:8080/spot/not_normal")
        .then(function (response) {   
     console.log(response.data);       
         })    
           .catch(function (error) {    
               
            console.error(error);      });
    }

    
}

     return(
         <div>
     <form >
<input type="radio" id="normal" name="normal" value="normal" onSelect=  { ()=> { slotType= "normal"}  }/>
  <label for="normal">normal</label><br></br>
  <input type="radio" id="Special Needs" name="Special Needs" value="Special Needs" onSelect=  { ()=> { slotType= "Notnormal"}  }/>
  <label for="Special Needs"> Special Needs</label><br></br>
  <button onClick={getSpot} > submit </button>
  </form>

  <form>
<label for="fname">First name:</label><br></br>
<input type="text" id="fname" name="fname"/>
  <label >Last name:</label>
  <input type="number" id="" name="number"></input>


  <label >phone Number:</label>
  <input type="text" ></input>

  <label >Plat Number:</label>
  <input type="text" ></input>

  <label >Spot-id:</label>
  <input type="text" ></input>
  <button > submit </button>
  </form>
         </div>
     )
 }
 export default Entry;