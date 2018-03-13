//基本控制层
app.controller('baseController',function ($scope) {
    //重新加载数据
    $scope.reloadList = function () {
        //切换页码
        //$scope.findPage($scope.paginationConf.currentPage,$scope.paginationConf.itemsPerPage);
        $scope.search($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
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
});