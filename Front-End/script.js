var xhr = new XMLHttpRequest(); 

function getUser(id){
    xhr.open("GET"," http://localhost:8080/customer",true); ~
    xhr.setRequestHeader("id",id);
    xhr.onreadystatechange = function(){
        if(this.readyState == 4 && this.status == 200){
            console.log(this.responseText);
        }
    }
    xhr.send(); 
}

getUser("7b4f86b7-4e74-4484-8138-f9c86062ca3e");