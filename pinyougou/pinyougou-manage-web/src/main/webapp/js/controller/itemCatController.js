app.controller("itemCatController", function ($scope, $controller, itemCatService, typeTemplateService) {

    $controller("baseitemCatController", {$scope: $scope})
    //加载列表数据
    $scope.findAll = function () {
        itemCatService.findAll().success(function (response) {
            $scope.list = response;
        });
    };

    $scope.findPage = function (page, rows) {
        itemCatService.findPage(page, rows).success(function (response) {
            $scope.list = response.rows;
            $scope.paginationItemCat.totalItems = response.total;
        });
    };

    $scope.save = function () {
        var object;
        if ($scope.entity.id != null) {//更新
            object = itemCatService.update($scope.entity);
        } else {//新增
            $scope.entity.parentId = $scope.parentId;
            object = itemCatService.add($scope.entity);
        }
        object.success(function (response) {
            if (response.success) {
                if ($scope.grade == 1) {
                    $scope.refresh($scope.entity.parentId);
                } else {
                    $scope.findByParentId($scope.entity.parentId);
                }
            } else {
                alert(response.message);
            }
        });
    };

    $scope.findOne = function (id) {
        itemCatService.findOne(id).success(function (response) {
            $scope.entity = response;
        });
    };

    $scope.delete = function () {
        if ($scope.selectedIds.length < 1) {
            alert("请先选择要删除的记录");
            return;
        }
        if ($scope.parentId != null) {
            $scope.tempId = $scope.parentId
        }
        if (confirm("确定要删除已选择的记录吗")) {
            itemCatService.delete($scope.selectedIds).success(function (response) {
                if (response.success) {
                    if ($scope.grade == 1) {
                        $scope.refresh($scope.tempId)
                    } else {
                        $scope.findByParentId($scope.tempId);
                    }
                    $scope.selectedIds = [];
                } else {
                    alert(response.message);
                }
            });
        }
    };

    $scope.searchEntity = {};//初始为空
    $scope.search = function (page, rows) {
        itemCatService.search(page, rows, $scope.searchEntity).success(function (response) {
            $scope.list = response.rows;
            $scope.paginationItemCat.totalItems = response.total;
        });
    };

    //根据父分类id查询其子分类
    $scope.findByParentId = function (parentId) {
        $scope.parentId = parentId; //记录父ID
        itemCatService.findByParentId(parentId).success(function (response) {
            $scope.list = response;
        });
    };

    //根据父分类id查询其子分类
    $scope.findByPageParentId = function (parentId, page, rows) {
        $scope.parentId = parentId; //记录父ID
        itemCatService.findByPageParentId(parentId, page, rows).success(function (response) {
            $scope.list = response.rows;
            $scope.paginationItemCat.totalItems = response.total;
        });
    };

    $scope.grade = 1;//默认1级
    $scope.selectList = function (grade, entity) {
        $scope.grade = grade;
        $scope.parentId = entity.parentId; //记录父ID
        switch (grade) {
            case 1:
                $scope.entity_1 = null;
                $scope.entity_2 = null;
                $scope.refresh(entity.id);
                break;
            case 2:
                $scope.entity_1 = entity;
                $scope.entity_2 = null;
                $scope.findByParentId(entity.id);
                break;
            default:
                $scope.entity_2 = entity;
                $scope.findByParentId(entity.id);
        }
    }

    $scope.typeTemplateList = {data: []};
    $scope.typeTemplateList = function () {
        typeTemplateService.selectOptionList().success(function (response) {
            $scope.typeTemplateList = {data: response};
        });
    }

    $scope.refresh = function (parentId) {
        $scope.paginationItemCat.currentPage = 1;
        $scope.paginationItemCat.itemsPerPage = 10;
        $scope.findByPageParentId(parentId, $scope.paginationItemCat.currentPage, $scope.paginationItemCat.itemsPerPage);
    }
});