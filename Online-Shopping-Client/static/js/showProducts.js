$.ajax({
    type:"GET",
    url:"/index",
    data:{},
    async: false,
    success:function (data) {
        var str="";
        var typeStr="";
        var nameStr="";
        for(var i=0;i<data.length;i++)
        {
            //data[i].photo = base64.b64decode(image.split(",")[1])
            str+="<li>"+
            "<img src=" +data[i].photo + ">" +
            "<p>"+ "<span>"+"&#165;"+data[i].price+"</span>"+
            "<br/>"+data[i].name+
            "<br/>"+data[i].type+
            "</p>"+"</li>";
            
            nameStr+="<option>"+data[i].name+
            "</option>";
            
            typeStr+="<option>"+data[i].type+
            "</option>";
        }
        document.getElementById("show").innerHTML=str;
        document.getElementById("loginbutton").value=data[0].user.username;
        document.getElementById("type").innerHTML=typeStr;
        document.getElementById("name").innerHTML=nameStr;
    }
});
