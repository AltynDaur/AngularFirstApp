angular.module('publicSchedule',['ui.bootstrap'])
    .controller('publicScheduleController',function($scope,$compile,$http){


        $scope.addSomeStaff = function(){
            var hello = 'hello';
            $http.post('schedule/resources/classdays',hello,{
                headers:{'Content-type':'text/plain'}
            }).success(function(data){
                if(data.status === 200){
                    console.log(data);
                }

            });
        };

        /*var date = new Date();
        var d = date.getDate();
        var m = date.getMonth();
        var y = date.getYear();

        $scope.renderCalender = function(calendar) {
            if(uiCalendarConfig.calendars[calendar]){
                uiCalendarConfig.calendars[calendar].fullCalendar('render');
            }
        };
        $scope.uiConfig = {
            calendar:{
                type:'Week',
                height: 450,
                editable: true,
                header:{
                    left: 'title',
                    center: '',
                    right: 'today prev,next'
                },

                eventClick: $scope.alertOnEventClick,
                eventDrop: $scope.alertOnDrop,
                eventResize: $scope.alertOnResize,
                eventRender: $scope.eventRender
            }
        };*/
    });