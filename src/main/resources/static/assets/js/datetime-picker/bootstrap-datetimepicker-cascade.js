;(function ($, window, document, undefined) {

    //限制时间区间 最小时间为2019-01-01
    var minDate = new Date();
    minDate.setFullYear(2019, 0, 1);
    minDate.setHours(0);

    // 工具函数
    var dateUtils = {
        //获取当月1号到今天的时间段
        getoneMonthUntilTodayArray: function () {
            var t = this
            var today = t.getFormatDate(new Date())

            var firstDayArr = today.split('-')
            firstDayArr[2] = '01'

            firstDay = firstDayArr.join('-')

            return [firstDay, today]
        },

        BIG_MONTHS: [1, 3, 5, 7, 8, 10, 12],

        //获取n个月前到今天的时间段(不传参为一个月)
        getPastMonthUntilTodayArray: function (count) {
            var t = this
            var count = count || 1
            var date = new Date(),
                pastMonthArr = []

            var today = t.getFormatDate(date)

            var year = date.getFullYear()

            //n个月前的月
            var month_r = date.getMonth() + 1 //月份是从0开始的
            var month = month_r - count

            if (month > 0) {
                month = month
            } else {
                month = 12 + month
                year -= 1
            }

            var day = date.getDate()

            pastMonthArr[0] = year;
            pastMonthArr[1] = month < 10 ? '0' + month : month;
            pastMonthArr[2] = day < 10 ? '0' + day : day;

            if (t.BIG_MONTHS.indexOf(month) !== -1 && day == 31) {
                if (month == 3) {
                    pastMonthArr[2] = t.isLeapYear(year) ? 29 : 28
                } else {
                    pastMonthArr[2] = 30
                }
            }

            //限制最小时间
            var past = Number(pastMonthArr.join(''));
            var pastMonth = past < 20190101 ? "2019-01-01" : pastMonthArr.join('-')

            // if (pastMonth == "2019-01-01") {
            //
            //     alert("只能查询2019年1月1日至今日的数据！");
            // }
            return [pastMonth, today]
        },

        //获取上n个月，月初月末的日期
        getLastNMonthRangeArray: function (count) {

            //本月
            if (count == 0) {

                var today = new Date();
                var monthFirst = today.setDate(1);
                // alert(monthFirst)
                return [this.getFormatDate(new Date(monthFirst)), this.getFormatDate(new Date())];
            }

            var monthBegin = new Date(), monthEnd;

            for (var i = 0; i < count; i++) {

                monthBegin = new Date(monthBegin.setDate(1));

                var monthEndTime = monthBegin.getTime() - 1e3 * 60 * 60 * 24;
                monthEnd = new Date(monthEndTime);

                monthBegin = new Date(new Date(monthEndTime).setDate(1));
            }
            var result = [this.getFormatDate(monthBegin), this.getFormatDate(monthEnd)];

            if (monthBegin < minDate && monthEnd < minDate) {

                alertMsg.info("只能查询2019年1月1日至今日的数据！");
                result = [this.getFormatDate(minDate), this.getFormatDate(new Date())];
            }
            return result;

        },

        //获取一周前到今天的时间段
        getOneWeekUntilTodayArray: function () {
            var t = this
            var OneWeekTime = (new Date()).getTime() - 1e3 * 60 * 60 * 24 * 7

            var OneWeek = t.getFormatDate(new Date(OneWeekTime))
            var today = t.getFormatDate(new Date())

            return [OneWeek, today]
        },

        //过去一个月，倒退30天
        getOneMonthUntilTodayArray: function () {
            var t = this
            var OneMonthTime = (new Date()).getTime() - 1e3 * 60 * 60 * 24 * 30

            var OneMonth = t.getFormatDate(new Date(OneMonthTime))
            var today = t.getFormatDate(new Date())

            return [OneMonth, today]
        },

        //过去三个月，倒退90天
        getThreeMonthUntilTodayArray: function () {
            var t = this
            var ThreeMonthTime = (new Date()).getTime() - 1e3 * 60 * 60 * 24 * 90

            var ThreeMonth = t.getFormatDate(new Date(ThreeMonthTime))
            var today = t.getFormatDate(new Date())

            var begin = ThreeMonth;
            if (ThreeMonthTime < new Date("2019-01-01")) {

                alertMsg.info("只能查询2019年1月1日至今日的数据！");
                begin = "2019-01-01";
            }

            console.log(begin)
            return [begin, today]
        },

        //查12个月到今天
        getLastYearUntilTodayArray: function () {
            var t = this
            var ThreeMonthTime = (new Date()).getTime() - 1e3 * 60 * 60 * 24 * 365

            var ThreeMonth = t.getFormatDate(new Date(ThreeMonthTime))
            var today = t.getFormatDate(new Date())

            var begin = ThreeMonth;
            if (ThreeMonthTime < new Date("2019-01-01")) {

                alertMsg.info("只能查询2019年1月1日至今日的数据！");
                begin = "2019-01-01";
            }
            return [begin, today]
        },


        //是否闰年
        isLeapYear: function (year) {
            return (year % 4 == 0) && (year % 100 != 0 || year % 400 == 0)
        },

        preArr: ['00', '01', '02', '03', '04', '05', '06', '07', '08', '09'],

        //输出字符串
        getFormatDate: function (date, format) {
            var t = this
            var format = format || 'YY-MM-DD'

            var year = date.getFullYear(),
                month = date.getMonth() + 1, //月份是从0开始的
                day = date.getDate()

            var newTime = format.replace(/YY/g, year)
                .replace(/MM/g, t.preArr[month] || month)
                .replace(/DD/g, t.preArr[day] || day)

            return newTime;
        },

        //获取最近月份的排序
        getRecentMonthArr: function () {
            var t = this,
                month = (new Date()).getMonth() + 1,
                recentMonthArr = []

            for (i = 0; i < 12; i++) {
                if (month <= 0) month = 12

                recentMonthArr.push(month)

                month--
            }

            return recentMonthArr
        }
    }

    var todayArray = [dateUtils.getFormatDate(new Date()), 0] //存储时计的时间, 0表示为空
    var oneMonthUntilTodayArray = dateUtils.getOneMonthUntilTodayArray() //存储日计的时间
    // var twelveMonthUntilTodayArray = dateUtils.getPastMonthUntilTodayArray(12) //存储月计的时间

    var pickerOptions = {
        language: 'zh-CN',
        weekStart: 0,
        todayBtn: 1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        // forceParse: 0,
        minView: 2,
        startDate: minDate,
        endDate: new Date(),

    }

    function DatetimePickCascade(options) {
        if (!options.name) {
            throw new ReferenceError("Missing property 'name'")
        } else {
            if (typeof options.name !== "string") {
                throw new TypeError("Property 'name' require String type")
            }
        }

        var _datetimePickCascade = $(options.name)

        this.$timeGroup = _datetimePickCascade.find('.time-group'), //时计，日计，月计选择框

            this.$datetimeControl_general = _datetimePickCascade.find('.datetime-control-general'), //日计，月计的日期控制
            this.$timeContent1 = this.$datetimeControl_general.children('.time-content1'), //日计，月计的日期内容1
            this.$timeContent2 = this.$datetimeControl_general.children('.time-content2'), //日计，月计的日期内容2

            this.$datePopup = _datetimePickCascade.find('.date-popup'), //弹出框

            this.$formDatetime1 = _datetimePickCascade.find('.form-datetime1'), //弹出框里面的日期选择器1
            this.$formDatetime2 = _datetimePickCascade.find('.form-datetime2'), //弹出框里面的日期选择器2

            this.$datetimeControl_shiji = _datetimePickCascade.find('.datetime-control-shiji'), //时计的日期选择器

            this.$updateBtn = _datetimePickCascade.find('.update-btn'),

            this.$datePopupLay = _datetimePickCascade.find('.datePopupLay'), //包裹一周前，一月前等那部分
            this.$oneWeekBtn = _datetimePickCascade.find('.1week-btn'), //过去一周按钮
            this.$oneMonthBtn = _datetimePickCascade.find('.1month-btn'),
            this.$threeMonthBtn = _datetimePickCascade.find('.3month-btn'),

            this.$monthGroup = _datetimePickCascade.find('.month-group'), //选择月份框

            this.icon_date_arrow = _datetimePickCascade.find('.icon-date-arrow')[0] //箭头图标


        this.timeType = options.timeType || 'daily' //1:时计，2:日计，3:月计
        this.chosenTimeArr = [] //存储选择器选择的时间
        this.callback = options.callback ? options.callback : undefined

        this.init(options.dateArr)
    }

    DatetimePickCascade.prototype.init = function (dateArr) {
        var self = this

        //注册日期选择器
        self.$formDatetime1.datetimepicker(pickerOptions)
        self.$formDatetime2.datetimepicker(pickerOptions)
        self.$datetimeControl_shiji.datetimepicker(pickerOptions)

        //限制时间区间 最小时间为2019-01-01


        setDateTime(self, dateArr, self.timeType);
        // if(self.timeType == 'hourly'){
        //
        //     setDateTime(self,todayArray,"hourly");
        // }else if(self.timeType == 'daily'){
        //
        //     setDateTime(self,oneMonthUntilTodayArray,"daily");
        // }else if(self.timeType == 'monthly'){
        //
        //     setDateTime(self,lastMonthUntilTodayArray,"monthly");
        // }

        self.$timeGroup.val(self.timeType)

        //给月份选择框赋值
        var recentMonth = dateUtils.getRecentMonthArr()
        var html = ''

        var prefix = '今年';
        recentMonth.forEach(function (v, index) {
            if (v == 12) {

                prefix = '去年';
            }
            html += '<option value="' + index + '">' + prefix + v + '月</option>'
        })
        self.$monthGroup.append(html)
        // console.log(html);

        self.attachEvents()
        refresh(this);
    }

    function refresh(self) {
        self.$formDatetime1.datetimepicker('setStartDate', minDate);
        self.$formDatetime1.datetimepicker('setEndDate', new Date(self.$timeContent2.text()));
        self.$formDatetime2.datetimepicker('setStartDate', new Date(self.$timeContent1.text()));
        self.$formDatetime2.datetimepicker('setEndDate', new Date());
    }

    function setDateTime(self, dateArr, timeType) {

        self.setDateContent(dateArr)
        self.chosenTimeArr[0] = dateArr[0]
        self.chosenTimeArr[1] = dateArr[1]

        self.setDisplay(timeType)
    }

    //限制时间区间
    DatetimePickCascade.prototype.attachEvents = function () {
        var self = this

        //时间选择器监听changeDate
        //弹窗里的时间选择器1
        //结束时间不超过开始时间
        self.$formDatetime1.datetimepicker().on('changeDate', function (ev) {
            self.chosenTimeArr[0] = dateUtils.getFormatDate(ev.date)

            if (self.timeType == 'daily' || self.timeType == 'monthly') {
                //限制下一个时间选择器
                self.$formDatetime2.datetimepicker('setStartDate', ev.date)
            }
        })
        //弹窗里的时间选择器2
        self.$formDatetime2.datetimepicker().on('changeDate', function (ev) {
            self.chosenTimeArr[1] = dateUtils.getFormatDate(ev.date)

            if (self.timeType == 'daily' || self.timeType == 'monthly') {
                //限制下一个时间选择器
                self.$formDatetime1.datetimepicker('setEndDate', ev.date)
            }
        })

        //时计选择器
        self.$datetimeControl_shiji.datetimepicker('setStartDate', minDate)
        self.$datetimeControl_shiji.datetimepicker('setEndDate', new Date())
        self.$datetimeControl_shiji.datetimepicker().on('changeDate', function (ev) {
            self.chosenTimeArr[0] = dateUtils.getFormatDate(ev.date)
            self.chosenTimeArr[1] = dateUtils.getFormatDate(new Date())

            self.$updateBtn.trigger('click')
        })


        //时计，日计，月计选择框切换
        self.$timeGroup.change(function () {
            console.log("set $timeGroup " + $(this).val())
            var val = $(this).val(),
                date

            if (val == 'hourly') { //时计

                self.timeType = val

                date = todayArray

                self.setDisplay('hourly')

            } else if (val == 'daily') { //日计

                self.timeType = val

                date = oneMonthUntilTodayArray

                self.setDisplay('daily')

            } else if (val == 'monthly') { //月计

                self.timeType = val

                date = dateUtils.getLastYearUntilTodayArray()

                self.setDisplay('monthly')
            }

            //设置时间
            self.setDateContent(date)
        })


        //更新按钮
        self.$updateBtn.click(function () {

            // self.$timeContent1.text()
            // self.$timeContent2.text()
            self.setDateContent(self.chosenTimeArr)
            // console.log(self.chosenTimeArr)
            // console.log(self.$timeContent1.text()+"  "+ self.$timeContent2.text())
            //
            // self.setDateContent([self.$timeContent1.text(),self.$timeContent2.text()])

            self.$datePopup.hide()
            self.icon_date_arrow.className = 'glyphicon glyphicon-chevron-down icon-date-arrow'

        })

        //一周
        self.$oneWeekBtn.click(function () {

            self.chosenTimeArr = dateUtils.getOneWeekUntilTodayArray()
            self.setDateContent(self.chosenTimeArr)
        })

        //一个月
        self.$oneMonthBtn.click(function () {

            self.chosenTimeArr = dateUtils.getOneMonthUntilTodayArray()
            self.setDateContent(self.chosenTimeArr)
        })

        //三个月
        self.$threeMonthBtn.click(function () {

            self.chosenTimeArr = dateUtils.getThreeMonthUntilTodayArray()

            console.log(self.chosenTimeArr)
            self.setDateContent(self.chosenTimeArr)
        })

        //月份选择
        self.$monthGroup.change(function () {

            console.log("$monthGroup")
            var val = $(this).val();

            var dateArr = dateUtils.getLastNMonthRangeArray(val)

            self.chosenTimeArr[0] = dateArr[0]
            self.chosenTimeArr[1] = dateArr[1]

            self.setDateContent(self.chosenTimeArr)
        })


        //显示隐藏时间选择器
        self.$datetimeControl_general.click(function () {
            var state = self.$datePopup.css('display')
            if (state === 'none') {
                self.$datePopup.show()
                self.icon_date_arrow.className = 'glyphicon glyphicon-chevron-up icon-date-arrow'
            }
            // else {
            //     self.$datePopup.hide()
            //     self.icon_date_arrow.className = 'glyphicon glyphicon-chevron-down icon-date-arrow'
            // }
        })

        //点击其他地方隐藏$datePopup
        $(document).on('mousedown touchend', function (e) {
            var target = $(e.target)
            if ((target.closest('.datetimepicker').length === 0)
                && (target.closest('.date-popup').length === 0)
                && (target.closest('.datetime-control-general').length === 0)
                && (target.closest('.jconfirm-buttons').length === 0)) {

                console.log("$datePopup " + self.icon_date_arrow)
                self.$datePopup.hide()

                if (self.icon_date_arrow.className != null)
                    self.icon_date_arrow.className = 'glyphicon glyphicon-chevron-down icon-date-arrow'
            }
        })
    }

    //控制部件的显示隐藏
    DatetimePickCascade.prototype.setDisplay = function (timeType) {
        var self = this

        if (timeType == 'hourly') {

            self.$datetimeControl_general.hide() //日计，月计控制器隐藏
            self.$datePopup.hide() //弹出框隐藏
            self.$datetimeControl_shiji.show() //时计日期选择器显示

        } else if (timeType == 'daily') {

            self.$datetimeControl_general.show()
            self.$datetimeControl_shiji.hide()

            self.$timeContent2.show()
            self.$timeContent2.prev().show()
            self.$formDatetime2.show()
            self.$formDatetime2.parent().prev().show()

            self.$datePopupLay.show()

        } else if (timeType == 'monthly') {

            self.$datetimeControl_general.show()
            self.$datetimeControl_shiji.hide()

            self.$timeContent2.show()
            self.$timeContent2.prev().show()
            self.$formDatetime2.show()
            self.$formDatetime2.parent().prev().show()

            self.$datePopupLay.hide()

        }
    }
    /**
     * [设置日期内容]
     * @param {Array}  dateArr   []
     */
    DatetimePickCascade.prototype.setDateContent = function (dateArr) {
        var self = this
        //console.log(dateArr)

        if (self.timeType == 'daily' || self.timeType == 'monthly') {
            self.$timeContent1.text(dateArr[0])
            self.$timeContent2.text(dateArr[1])

            self.$formDatetime1.datetimepicker('setDate', new Date(dateArr[0]))
            self.$formDatetime2.datetimepicker('setDate', new Date(dateArr[1]))

        } else if (self.timeType == 'hourly') {
            //时计只有一个日期
            self.$datetimeControl_shiji.datetimepicker('setDate', new Date(dateArr[0]))

        }
        refresh(this);
        self.callback && self.callback(dateArr)
    }


    window.DatetimePickCascade = DatetimePickCascade

})(jQuery, window, document)
