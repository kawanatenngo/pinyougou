//文件上传到服务器
app.service("uploadService",function ($http) {
    this.uploadFile = function () {
        var formData = new FormData();
        formData.append("file", file.files[0]);//file 文件上传框的name
        return $http({
            method:'POST',
            url:"../upload.do",
            data:formData,
            headers:{'Content-Type':undefined},
            transformRequest:angular.identity
        });
    }
});