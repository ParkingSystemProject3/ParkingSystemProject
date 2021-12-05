import axios from "axios";

 function Entry(){
     let slotType;
     let data={id:0};

function getSpot(event){
    event.preventDefault();
    console.log("in")
    if (slotType=="normal"){
        console.log("inin")
        axios.get("http://localhost:8080/spot/normal")
        .then(function (response) { 
            data=response.data;  
     console.log(response.data);       
         })    
           .catch(function (error) {    
               
            console.error(error);      });
    }
   
    else{
        axios.get("http://localhost:8080/spot/not_normal")
        .then(function (response) {   
     console.log(response.data);       
         })    
           .catch(function (error) {    
               
            console.error(error);      });
    }

    
}
function addUser(event){
    console.log("d")
    event.preventDefault();
    let user ={ fName:"",lName:"",platNumber:0, phone:0,spot:{id:0}}
    user.fName= document.getElementById("fname").value;
    user.lName= document.getElementById("lname").value;
    user.platNumber= document.getElementById("platnum").value;
    user.phone= document.getElementById("number").value; 
    user.spot.id= document.getElementById("spotId").value; 

    axios.post('http://localhost:8080/users', user).then(function (response) {   
               console.log("vf")
            })    
              .catch(function (error) {    
                  
               console.error(error); });

}

     return(
         <div>
     <form>
<input type="radio" id="normal" name="normal" value="normal" onClick=  { ()=> { slotType= "normal"}  }/>
  <label for="normal">normal</label><br></br>
  <input type="radio" id="Special Needs" name="Special Needs" value="Special Needs" onClick=  { ()=> { slotType= "Notnormal"; console.log("ff")}  }/>
  <label for="Special Needs"> Special Needs</label><br></br>
  <button onClick={getSpot} > submit </button>
  </form>
<h1>{data.id}</h1>
  <form>
<label for="fname">First name:</label><br></br>
<input type="text" id="fname" name="fname"/>

  <label >Last name:</label>
  <input type="text" id="lname" name="lname"></input>

  <label >Plat Number:</label>
  <input type="text" id="platnum"></input>

  <label >phone Number:</label>
  <input type="text" id="number" ></input>

  

  <label >Spot-id:</label>
  <input type="text" id="spotId"></input>
  <button onClick={addUser}> submit </button>
  </form>
         </div>
     )
 }
 export default Entry;