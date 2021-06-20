var myObj= {
    hide: function() {
    document.getElementById("form").style.display = "none";
    document.getElementById("show").style.display = "inline-block";

    },
    show:function(){

    document.getElementById("form").style.display = "block";
    document.getElementById("show").style.display = "none";
    },
    
};

function add() {
    const resp = await addUser(username.value, password.value);
}