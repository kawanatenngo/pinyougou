//基本控制层
app.controller('baseController',function ($scope) {
    //重新加载数据
    $scope.reloadList = function () {
        //切换页码
        //$scope.findPage($scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage);
        $scope.search($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
        //解决选中后，刷新了还在列表的情况
        $scope.selectIds=[];
    };
    //分页控件配置
    $scope.paginationConf = {
        currentPage : 1,
        //totalItems : 10,	注释掉，就不会发起重复请求
        itemsPerPage : 10,
        perPageOptions : [10,20,30,40,50],
        onChange : function () {
            $scope.reloadList();//重新加载
        }
    };
    //选中的id集合
    $scope.selectIds = [];
    //更新复选
    $scope.updateSelection = function ($event, id) {
        if($event.target.checked){//如果是被选中，则增加到数组
            $scope.selectIds.push(id);
        }else {
            var idx = $scope.selectIds.indexOf(id);
            $scope.selectIds.splice(idx, 1);//删除
        }
    };
    //提取json字符串数据中某个属性，返回拼接字符串，逗号分隔
    $scope.jsonToString = function (jsonString, key) {
        var json = JSON.parse(jsonString);
        var value = "";
        for (var i=0;i<json.length;i++) {
            if(i>0) {
                value += ",";
            }
            value += json[i][key];
        }
        return value;
    };
    //从集合中按照key查询对象
    $scope.searchObjectByKey = function (list, key, keyValue) {
        try {
            for (var i = 0; i < list.length; i++) {
                if (list[i][key] == keyValue) {
                    return list[i];
                }
            }
        } catch (err) {
            return null;
        }
        return null;
    }
});