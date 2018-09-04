app.controller("brandController", function ($scope,$controller,brandService) {
    $controller("baseController",{$scope:$scope})
    //添加品牌数据
    $scope.add = function () {
        var obj;
        if ($scope.entity.id != null) {
            obj = brandService.update($scope.entity)
        }else{
            obj = brandService.add($scope.entity);
        }

        obj.success(function (response) {
            if (response.success) {
                //重新加载数据
                $scope.reloadList();
            }else {
                alert(response.message);
            }
        })
    }
    //删除数据
    $scope.delete = function(){
        if($scope.selectedIds.length < 1){
            alert("请选择要删除的选项");
            return;
        }
        if(confirm("确定要删除选中的选项？")){
            brandService.delete($scope.selectedIds).success(function (response) {
                if(response.success){
                    $scope.reloadList();
                    $scope.selectedIds = [];
                }else{
                    alert(response.message)
                }
            })
        }
    }
    //根据主键查询数据
    $scope.findOne = function (id) {
        brandService.findOne(id).success(function (response) {
            $scope.entity = response;
        });
    }
    //查询所有数据
    $scope.findAll = function(){
        brandService.findAll().success(function (response) {
            $scope.list = response;
        })
    }
    //查询数据
    $scope.searchEntity = {}
    $scope.search = function(page,rows){
        brandService.search(page,rows,$scope.searchEntity).success(function (response) {
            $scope.list = response.rows;
            $scope.paginationConf.totalItems = response.total;
        }).error(function () {
            alert("获取品牌列表失败");
        });
    }
})
