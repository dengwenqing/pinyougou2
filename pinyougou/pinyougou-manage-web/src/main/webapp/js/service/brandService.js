app.service("brandService",function($http){
    //添加品牌数据
    this.add = function(entity){
        return $http.post("../brand/add.do", entity);
    }
    //修改品牌数据
    this.update = function(entity){
        return $http.post("../brand/update.do",entity);
    }
    //根据主键查询数据
    this.findOne = function(id){
        return $http.get("../brand/findOne.do?id=" + id);
    }
    //删除数据
    this.delete = function(selectedIds){
        return $http.post("../brand/delete.do?ids=" + selectedIds);
    }
    //查询所有数据
    this.findAll = function(){
        return $http.get("../brand/findAll.do");
    }
    //查询数据
    this.search = function(page,rows,searchEntity){
        return $http.post("../brand/search.do?page=" + page + "&rows=" + rows,searchEntity);
    }

    //查询品牌数据列表
    this.selectOptionList = function(){
        return $http.get("../brand/selectOptionList.do");
    }
})