;(function ($, window, document, undefined) {

    //限制时间区间 最小时间为2019-01-01
    var minDate = new Date();
    minDate.setFullYear(2019, 0, 1);
    minDate.setHours(0);

    // 工具函数
    var dateUtils = {

        //获取一周前到今天的时间段
        getOneWeekUntilTodayArray: function () {
            var t = this
            var OneWeekTime = (new Date()).getTime() - 1e3 * 60 * 60 * 24 * 7

            var OneWeek = t.getFormatDate(new Date(OneWeekTime))
            var today = t.getFormatDate(new Date())

            return [OneWeek, today]
        },

        preArr: ['00', '01', '02', '03', '04', '05', '06', '07', '08', '09'],

        //格式化日期
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
        }
    }

    var pickerOptions = {
        language: 'zh-CN',
        weekStart: 0,
        todayBtn: 1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        forceParse: 0,
        minView: 2,

        startDate: minDate,
        endDate: new Date(),
    }

    var oneWeekUntilTodayArray = dateUtils.getOneWeekUntilTodayArray() //存储一周前到今天的时间
    function DatetimePickNormal(options) {
        if (!options.name) {
            throw new ReferenceError("Missing property 'name'")
        } else {
            if (typeof options.name !== "string") {
                throw new TypeError("Property 'name' require String type")
            }
        }

        var _datetimePickCascade = $(options.name)
        if (options.parentSelector) {
            this.$parentDom = $(options.parentSelector)
        } else {
            this.$parentDom = _datetimePickCascade.parent("div");
        }
        this.id = options.name;
        this.$datetimeControl_general = _datetimePickCascade.find('.datetime-control-general'), //日期控制
            this.$timeContent1 = this.$datetimeControl_general.children('.time-content1'), //日期内容1
            this.$timeContent2 = this.$datetimeControl_general.children('.time-content2'), //日期内容2

            this.$datePopup = _datetimePickCascade.find('.date-popup'), //弹出框

            this.$formDatetime1 = _datetimePickCascade.find('.form-datetime1'), //弹出框里面的日期选择器1
            this.$formDatetime2 = _datetimePickCascade.find('.form-datetime2'), //弹出框里面的日期选择器2

            this.$updateBtn = _datetimePickCascade.find('.update-btn'),

            this.icon_date_arrow = _datetimePickCascade.find('.icon-date-arrow')[0]; //箭头图标

        this.chosenTimeArr = [] //存储选择器选择的时间
        this.callback = options.callback ? options.callback : undefined

        this.init(options.dateArr)//初始化
    }

    DatetimePickNormal.prototype.init = function (dateArr) {
        var self = this

        if (dateArr) {

            oneWeekUntilTodayArray = dateArr;
        }

        //给选择框赋值
        self.setDateContent(oneWeekUntilTodayArray)

        //注册日期选择器
        self.$formDatetime1.datetimepicker(pickerOptions)
        self.$formDatetime2.datetimepicker(pickerOptions)

        self.$formDatetime1.datetimepicker('setStartDate', minDate);
        self.$formDatetime1.datetimepicker('setEndDate', new Date(self.$timeContent2.text()));

        self.$formDatetime2.datetimepicker('setStartDate', new Date(self.$timeContent1.text()));
        self.$formDatetime2.datetimepicker('setEndDate', new Date());

        self.chosenTimeArr[0] = oneWeekUntilTodayArray[0]
        self.chosenTimeArr[1] = oneWeekUntilTodayArray[1]

        self.attachEvents()

        self.$formDatetime1.datetimepicker('setDate', new Date(oneWeekUntilTodayArray[0]))
        self.$formDatetime2.datetimepicker('setDate', new Date(oneWeekUntilTodayArray[1]))
    }

    DatetimePickNormal.prototype.attachEvents = function () {
        var self = this

        //时间选择器监听changeDate
        //弹窗里的时间选择器1
        self.$formDatetime1.datetimepicker().on('changeDate', function (ev) {
            self.chosenTimeArr[0] = dateUtils.getFormatDate(ev.date)

            //限制下一个时间选择器
            self.$formDatetime2.datetimepicker('setStartDate', ev.date)
        })
        //弹窗里的时间选择器2
        self.$formDatetime2.datetimepicker().on('changeDate', function (ev) {
            self.chosenTimeArr[1] = dateUtils.getFormatDate(ev.date)

            self.$formDatetime1.datetimepicker('setEndDate', ev.date)
        })


        //更新按钮
        self.$updateBtn.click(function () {
            self.setDateContent(self.chosenTimeArr)
            self.$datePopup.hide()
            self.icon_date_arrow.className = 'glyphicon glyphicon-chevron-down icon-date-arrow'
        })

        //显示隐藏时间选择器
        self.$datetimeControl_general.click(function () {
            var state = self.$datePopup.css('display')
            if (state === 'none') {
                self.$datePopup.show()
                self.icon_date_arrow.className = 'glyphicon glyphicon-chevron-up icon-date-arrow'
            }
            if (self.$parentDom) {
                var allDatetimePickers = self.$parentDom.find(".datetime-pick-normal");
                if (allDatetimePickers) {
                    $.each(allDatetimePickers, function (index, datePicker) {
                        if (("#" + $(datePicker).attr("id")) != self.id) {
                            var showState = $(datePicker).find('.date-popup').css('display');
                            if (showState === "block") {
                                $(datePicker).find('.date-popup').hide();
                                $(datePicker).find('.icon-date-arrow')[0].className = "glyphicon glyphicon-chevron-down icon-date-arrow";
                            }
                        }
                    })
                }
            }
        })

        //点击其他地方隐藏$datePopup
        $(document).on('mousedown touchend', function (e) {
            var target = $(e.target)
            if ((target.closest('.datetimepicker').length === 0) && (target.closest('.date-popup').length === 0) && (target.closest('.datetime-control-general').length === 0)) {
                self.$datePopup.hide()
                self.icon_date_arrow.className = 'glyphicon glyphicon-chevron-down icon-date-arrow'
            }
        })
    }

    /**
     * [设置日期内容]
     * @param {Array}  dateArr   []
     */
    DatetimePickNormal.prototype.setDateContent = function (dateArr) {
        var self = this

        self.$timeContent1.text(dateArr[0])
        self.$timeContent2.text(dateArr[1])

        self.callback && self.callback(dateArr)
    }


    window.DatetimePickNormal = DatetimePickNormal

})(jQuery, window, document)
