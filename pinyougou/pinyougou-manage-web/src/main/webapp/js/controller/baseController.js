app.controller("baseController", function ($scope) {
    //加载数据
    $scope.reloadList = function () {
        $scope.search(
            $scope.paginationConf.currentPage,
            $scope.paginationConf.itemsPerPage
        );
    }
    //初始化分页参数
    $scope.paginationConf = {
        currentPage: 1,//当前页号
        totalItems: 10,//总记录数
        itemsPerPage: 5, //每页大小
        perPageOptions: [5, 10, 15, 20, 25, 30],
        onChange: function () {
            $scope.reloadList();
        }
    }
    //定义一个选择了的id数组
    $scope.selectedIds = [];
    $scope.updateSelection = function (event, id) {
        if (event.target.checked) {
            $scope.selectedIds.push(id);
        } else {
            var index = $scope.selectedIds.indexOf(id);
            $scope.selectedIds.splice(index, 1);
        }
    }

    $scope.jsonToString = function (json, key) {
        var str = "";
        var jsonArray = JSON.parse(json);
        for (var i = 0; i < jsonArray.length; i++) {
            if (i > 0) {
                str += "，";
            }
            str += jsonArray[i][key];
        }
        return str;
    }
})