angular.module('publicSchedule',['ui.bootstrap','ui.calendar'])
    .controller('publicScheduleController',function($scope,$compile,uiCalendarConfig){
        var date = new Date();
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
                height: 450,
                editable: true,
                header:{
                    left: 'title',
                    center: '',
                    right: 'today prev,next'
                },
                viewType:'agendaWeek',
                eventClick: $scope.alertOnEventClick,
                eventDrop: $scope.alertOnDrop,
                eventResize: $scope.alertOnResize,
                eventRender: $scope.eventRender
            }
        };
    });