import axios from "axios";

function Exit() {
    // هذا المتغير يكون فيه معلومات التكت اللي تنطبع على الشاشة
    let ticket;
  
    function ExitUser(event){
        event.preventDefault();
        let pn = document.getElementById("platNum").value;
        console.log("in pn")
        axios.put(`http://localhost:8080/ticket/${pn}`)
        .then(function (response) { 
            axios.get(`http://localhost:8080/ticket/${pn}`)
        .then(function (response) { 
            ticket=response.data;

         })    
           .catch(function (error) {    
               
            console.error(error);});       
         })    
           .catch(function (error) {    
               
            console.error(error);});
            
    }
    return(
        <div>
            <form>
<label for="platNum">Plate Number:</label><br></br>
<input type="text" id="platNum" name="platNum"/>
  <button onClick={ExitUser}> submit </button>
  </form>

        </div>
    )
}
export default Exit;
