function selectFile(){
    var files = document.getElementById('pic').files;
    console.log(files[0]);
    if(files.length == 0){
        return;
    }
    var file = files[0];
    //把上传的图片显示出来
    var reader = new FileReader();
    // 将文件以Data URL形式进行读入页面
    console.log(reader);
    reader.readAsBinaryString(file);
    reader.onload = function(f){
        var result = document.getElementById("img");
        var src = "data:" + file.type + ";base64," + window.btoa(this.result);
        result.innerHTML = '<img src ="'+src+'"/>';
    }
    console.log('file',file);
    ///////////////////
    form.append('file',file);
    console.log(form.get('file'));
};