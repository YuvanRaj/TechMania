var myfirstApp=angular.module("MyFirstApp",['ngGrid']);



//Controller Configuration
myfirstApp.controller('myFirstAppController',['$scope','$http',function($scope,$http){

	
$scope.filterOptions = {
	filterText: ''
};



$scope.taskDetailList =[];

var selectedTaskIds = [];

$scope.selectedItems =[];

$scope.getTaskByDetailByStatus=function(status) {
	$http.get("http://192.168.1.6:8080/services/taskdetail/getTaskDetailsByStatus/"+status)
	.success(function(response) {
		$scope.taskDetailList = response;
	});
};

$scope.addTaskDetail=function(taskDetail) {
		$http({
	    method: 'POST',
	    url: "http://192.168.1.6:8080/services/taskdetail/addTaskDetail",
	    data: taskDetail,
	    headers: {'Content-Type': 'application/json'}
	}).success(function (data, status, headers, config) {
		$scope.getTaskByDetailByStatus('PENDING');
    }).error(function (data, status, headers, config) {
        $scope.status = status;
    });
};

$scope.deleteTaskDetail = function(){
	$http({
	    method: 'POST',
	    url: "http://192.168.1.6:8080/services/taskdetail/removeTaskDetail",
	    data: $scope.gridOptions.selectedItems,
	    headers: {'Content-Type': 'application/json'}
	}).success(function (data, status, headers, config) {
		$scope.getTaskByDetailByStatus('PENDING');
    }).error(function (data, status, headers, config) {
        $scope.status = status;
    });
}





$scope.gridOptions = { 
	data: 'taskDetailList',
	filterOptions: $scope.filterOptions,
	selectedItems: [],
	showFilter: true,
	showSelectionCheckbox:true,
	columnDefs: [{
		field: 'taskId',
		displayName: 'Task Id'
	}, {
		field: 'taskDescription',
		displayName: 'Task Description'
	}, {
		field: 'taskDate',
		displayName: 'Task Date'
	}],
	enablePaging: true,
	showFooter: true,
	enablePinning: true
};



}]);