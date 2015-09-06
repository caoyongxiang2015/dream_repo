/**
 * Created by caihuazhi on 14-01-16.
 * @need jquery, bootstrap, bootstrap-datepicker, bootstrap-timepicker, bootstrap-chosen, jquery.form, port, portSelector, icheck
 */

// Chemon
!(function($, window) {
    var tradx = function() {
        var method = {
            // 封装console.log方法，防止在IE中出错
            log : function(obj) {
                if (!window.console || !window.console.log) return;
                window.console.log(obj);
            },
            // 判断浏览器是否小于IE9
            ltIE9 : (window.navigator.userAgent.match(/msie \d{1,2}/i) && window.navigator.userAgent.match(/msie \d{1,2}/i)[0].substring(5) - 0 < 10),
            // 判断设备是否为IPAD
            isPad : window.navigator.userAgent.match(/ipad/i),
            // 延迟跳转
            jumpDelay : function(target, url, seconds) {
                if (!target.text) target = $(target);
                var timmer = setInterval(function() {
                    target.text(--seconds);
                    if (!seconds) {
                        clearInterval(timmer);
                        location.href = url;
                    }
                }, 1000)

            }
        };
        return {
            log : method.log,
            ltIE9: method.ltIE9,
            isPad: method.isPad,
            jumpDelay : method.jumpDelay
        }
    }();
    window.tradx = window.Tradx = tradx;
})(jQuery, window);

// PLUGIN
// **************************
/**
 * 对Date的扩展，将 Date 转化为指定格式的String
 * 月(M)、日(d)、12小时(h)、24小时(H)、分(m)、秒(s)、周(E)、季度(q) 可以用 1-2 个占位符
 * 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)
 * eg:
 * (new Date()).pattern("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423
 * (new Date()).pattern("yyyy-MM-dd E HH:mm:ss") ==> 2009-03-10 二 20:09:04
 * (new Date()).pattern("yyyy-MM-dd EE hh:mm:ss") ==> 2009-03-10 周二 08:09:04
 * (new Date()).pattern("yyyy-MM-dd EEE hh:mm:ss") ==> 2009-03-10 星期二 08:09:04
 * (new Date()).pattern("yyyy-M-d h:m:s.S") ==> 2006-7-2 8:9:4.18
 */
Date.prototype.pattern=function(fmt) {
    var o = {
        "M+" : this.getMonth()+1, //月份
        "d+" : this.getDate(), //日
        "h+" : this.getHours()%12 == 0 ? 12 : this.getHours()%12, //小时
        "H+" : this.getHours(), //小时
        "m+" : this.getMinutes(), //分
        "s+" : this.getSeconds(), //秒
        "q+" : Math.floor((this.getMonth()+3)/3), //季度
        "S" : this.getMilliseconds() //毫秒
    };
    var week = {
        "0" : "/u65e5",
        "1" : "/u4e00",
        "2" : "/u4e8c",
        "3" : "/u4e09",
        "4" : "/u56db",
        "5" : "/u4e94",
        "6" : "/u516d"
    };
    if(/(y+)/.test(fmt)){
        fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
    }
    if(/(E+)/.test(fmt)){
        fmt=fmt.replace(RegExp.$1, ((RegExp.$1.length>1) ? (RegExp.$1.length>2 ? "/u661f/u671f" : "/u5468") : "")+week[this.getDay()+""]);
    }
    for(var k in o){
        if(new RegExp("("+ k +")").test(fmt)){
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
        }
    }
    return fmt;
};



// APP INIT
// **************************
// 防止boostrap-datepicker与jquery-ui的datepicker冲突
var bootstrapDatepicker =  $.fn.datepicker.noConflict();
$.fn.bootstrapDatepicker = bootstrapDatepicker;

// App
!(function($, window) {
    var app = function() {
        var method = {
            handleDatepicker : function() {
                var ctx = arguments.length > 0 ? arguments[0] : null,
                    t = $("input.date-picker", ctx);
                if (!t.length) return 0;
                if (!$.fn.bootstrapDatepicker) return chemon.log('handleDatepicker init failed! datepicker is undefined!');
                return t.prop('readonly',true).bootstrapDatepicker({
                    format : 'yyyy-mm-dd',
                    autoclose : true,
                    weekStart: 1
                }).wrap("<span style='position:relative;display:inline-block'></span>").after("<i class='remove'></i>").next(".remove").click(function(){$(this).prev("input.date-picker").val("")});
            },
			handleTimepicker : function() {
                var ctx = arguments.length > 0 ? arguments[0] : null,
                    t = $("input.time-picker", ctx);
                if (!t.length) return 0;
                if (!$.fn.timepicker) return console.log('handleTimepicker init failed! timepicker is undefined!');
                return t.prop('readonly',true).timepicker({
                    minuteStep:30,
                    showSeconds: false,
                    showMeridian: false // 是否是12小时制
                });
            },
            handleChosen : function() {
                var ctx = arguments.length > 0 ? arguments[0] : null,
                    t = $("select.chosen", ctx);
                if (!t.length) return 0;
                if (!$.fn.chosen) return chemon.log('handleChosen init failed! chosen is undefined!');
                return t.chosen({allow_single_deselect: true});
            },
            handleIcheck : function() {
                var ctx = arguments.length > 0 ? arguments[0] : null,
                    t= $("input.icheck", ctx),
                    _types = ['blue', 'orange', 'red', 'green', 'yellow', 'grey', 'pink', 'purple', 'white'];
                if (!t.length) return 0;
                if (!$.fn.iCheck) return chemon.log('handleIcheck init failed! icheck is undefined!');
                return t.each(function() {
                    var $this = $(this), _type = '-blue', i, j;
                    for (i = 0, j = _types.length; i < j; i++) {
                        if ($this.hasClass(_types[i])) {
                            _type = '-' + _types[i];break;
                        }
                    }
                    $this.iCheck({
                        checkboxClass : ('icheckbox_minimal' + _type),
                        radioClass : ('iradio_minimal' + _type)
                    });
                });
            },
            handleAccordion : function() {
                var ctx = arguments.length > 0 ? arguments[0] : null;
                if (!$.fn.collapse) return chemon.log('handleAccordion init failed! collapse is undefined!');
                $(ctx).on("show", ".accordion-group", function() {
                    $(this).addClass("active");
                }).on("hide", ".accordion-group", function() {
                    $(this).removeClass("active");
                });
            },
            handleEmailAutocomplete: function() {
                var ctx = arguments.length > 0 ? arguments[0] : null,
                    t = $("input.email", ctx),
                    rule = ["gmail.com", "hotmail.com", "live.com", "aol.com", "sina.com","sunivo.com","sina.com.cn"];
                if (!t.length) return 0;
                if (!$.fn.typeahead) return chemon.log('handleEmailAutocomplete init failed! typeahead is undefined!');
                return t.attr('autocomplete','off').typeahead({
                    source : function(item, arg2) {
                        var _result = [], f = item.match(/\@/i), _temp, i, j = rule.length;
                        if (!f) {
                            for (i = 0; i < j; i++) {
                                _result.push(item.toLowerCase() + "@" + rule[i]);
                            }
                        } else {
                            _temp = item.split(/\@/);
                            for (i = 0; i < j; i++) {
                                rule[i].match(_temp[1]) ? _result.push(_temp[0].toLowerCase() + "@" + rule[i]) : 1;
                            }
                        }
                        return _result;
                    }
                });
            },
            handleFileupload: function() {
                var ctx = arguments.length > 0 ? arguments[0] : null,
                    t = $("label.file-label");
                if (!t.length) return 0;
                if (!$.fn.ajaxSubmit) return chemon.log('handleFileupload init failed! need jquery.form.js!');
                t.on("change", "input:file", function() {
                    var $this = $(this),
                        _fileGroup = $this.parents('.file-group'),
                        _fileLabel = _fileGroup.find('label.file-label'),
                        _fileProgress = _fileGroup.find(".file-progress"), // 上传进度显示域
                        _fileReturn = _fileGroup.find(".file-return"), // 返回值
                        _form = _fileLabel.wrap('<form method="post" class="nonestyle"></form>').parent(), // 将表单用form包住
                        _fileName = $this.attr('name'),
                        _defaultdata = {name : '', url : '', info : ''};
                    $this.attr("name", "picture"); // 将表单的name临时改成后台需要的公共name
                    _form.ajaxSubmit({
                        url : $this.data("uploadurl"),
                        resetForm : true, // 提交成功后重置表单
                        iframe : true,
                        beforeSubmit : function(formData, jqForm, options) {
                            var obj = {};
                            // 遍历表单
                            for (var i = 0, j = formData.length; i < j; i++) {
                                if (formData[i]["name"] === "picture") {
                                    obj = formData[i];break;
                                }
                            }
                            var _imageName = (typeof obj.value === "object") ? obj.value.name : obj.value.match(/[\w\_\-\.]+$/i)[0];
                            if (_imageName.match(/\.(jpg|png|bmp|jpeg|pdf|txt)$/ig)) {
                                return true;
                            } else {
                                alert("The file format is invalid！");
                                $this.attr("name", _fileName); // 恢复表单名
                                _form.resetForm(); // 重置此部分表单
                                _form.children().unwrap(); // 清除wrap
                                return false;
                            }
                        },
                        beforeSend : function() {
                            _fileProgress.text("0");
                        },
                        uploadProgress : function(event, position, total, percentComplete) {
                            _fileProgress.text(percentComplete);
                        },
                        success : function(responseText, statusText, xhr, $form) {
                            var _data = $.parseJSON(responseText);
                            _data = $.extend(_defaultdata, _data);
                            var path = $this.data("path") || '';
                            _fileReturn.each(function() {
                                var _tagname = this.tagName.toUpperCase();
                                if (_tagname == 'INPUT') {
                                    $(this).val(_data.name);
                                } else if (_tagname == 'IMG') {
                                    $(this).attr('src', path + _data.url);
                                } else {
                                    $(this).text(_data.info);
                                }
                            });
                            $this.attr("name", _fileName); // 恢复表单名
                            _form.children().unwrap(); // 清除wrap
                            if (_data.error) return; // 如果上传时服务器返回错误状态，则不执行下面的自定义函数
                            // 自定义回调函数
                            if (typeof $this.data("callback") === 'function') $this.data("callback").apply($this.get(0), [_data, statusText]);
                        }
                    });
                });
            },
            handleHref : function() {
                var ctx = arguments.length > 0 ? arguments[0] : document;
                if (!$(ctx).length) return 0;
                return $(ctx).on("click", "[data-href]", function() {
                    if ($(this).hasClass('active')) return;
                    window.location.href = $(this).data("href");
                });
            },
            handleAjaxLoad : function() {
                var ctx = arguments.length > 0 ? arguments[0] : null,
                    t = $("[data-ajaxurl]", ctx);
                if (!t.length) return 0;
                return t.each(function() {
                    var that = $(this);
                    that.load(that.data("ajaxurl"), that.data("param"), function() {
                        that.trigger("ajaxcallback");
                    });
                });
            },
            handleScrolltop : function() {
                var w = $(window), t = $("#scrolltop"), max = 400;
                if (!t.length) return 0;
                w.scrollTop() < max ? t.hide() : t.show();
                t.click(function(e) {
                    e = e || window.event;e.preventDefault();
                    t.blur();
                    $("html,body").animate({scrollTop : 0}, 300);
                });
                return w.on("scroll", function() {
                    w.scrollTop() >= max ? t.fadeIn() : t.fadeOut();
                });

            },
            handleFormReset : function() {
                var ctx = arguments.length > 0 ? arguments[0] : null,
                    t = $("button[type=reset],input[type=reset]", ctx);
                if (!t.length) return 0;
                return t.click(function(e) {
                    e = e || window.event; e.preventDefault();
                    var _form = $(this).parents("form");
                    _form.get(0).reset();
                    _form.trigger("reset");
                    _form.find("input.icheck").iCheck("update");
                    _form.find("select.chzn-done").trigger("liszt:updated");
                });
            }
        };

        return {
            /**
             * 初始化方法
             */
            init : function() {
            	(function($){
            		//chosen下拉框部分被遮住bug
            	    if($('.accordion-heading').length){
            	        $('.accordion-heading').on('click','[data-toggle="collapse"]',function(e){
                            var $target = $(e.target),$body = $target.closest('.accordion-group').find('.accordion-body');
            	            if($body.hasClass('in')){
                                $body.removeClass('out');
            	            }else{
            	                setTimeout(function(){
                                    $body.addClass('out');
            	                },200);
            	            }
            	        });
            	    }
            	})(jQuery);
                !method.handleDatepicker();
                !method.handleChosen();
                !method.handleIcheck();
                !method.handleScrolltop();
                !method.handleFormReset();
				!method.handleTimepicker();
                //!method.handleEmailAutocomplete(); // 邮箱联想，手动调用
                //!method.handleFileupload(); // 上传，手动调用
                //!method.handleAccordion(); // 手动调用，避免绑定过多事件
                //!method.handleHref(); // 同上
                !method.handleAjaxLoad(); // 打开，每个页面都有
                $(document).trigger('initover'); // 控制JS的执行先后顺序，将其它的方法放到事件完成后执行。
            },
            /**
             * 局部初始化
             * @param _methods 字符串，调到的方法
             * @param ctx 上下文，可直接用选择器，如'#form1'
             */
            initWithContext : function(_methods, ctx) {
                var ary = _methods.split(','), i, j;
                if (typeof ctx == 'object') ctx = ctx[0];
                for (i = 0, j = ary.length; i < j; i++) {
                    !ary[i].match(/handle/i) && (ary[i] = 'handle' + ary[i]);
                    !method[ary[i]].apply(this, [ctx]);
                }
            }
        };
    }();
    window.app = window.App = app;
})(jQuery, window);




// BOX ALERT
!(function($) {
    var Box = function (element, options) {
        this.options = options
        this.$element = $(element).delegate('[data-dismiss="box"]', 'click.dismiss.box', $.proxy(this.hide, this))
        this.options.remote && this.$element.find('.box-body').load(this.options.remote)
    }
    Box.prototype = {
        constructor: Box,
        toggle: function () {
            return this[!this.isShown ? 'show' : 'hide']()
        },
        show: function () {
            var that = this
            // , e = $.Event('boxshow')
            // this.$element.trigger(e)
            if (this.isShown) return
            this.isShown = true
            this.escape()
            this.backdrop(function () {
                var transition = $.support.transition && that.$element.hasClass('fade')
                if (!that.$element.parent().length) {
                    that.$element.appendTo(document.body) //don't move boxs dom position
                }
                that.$element.show()
                if (transition) {
                    that.$element[0].offsetWidth // force reflow
                }
                that.$element.addClass('in').attr('aria-hidden', false)
                that.enforceFocus();
                $(document).trigger('custom');
            })
        },
        hide: function (e) {
            e && e.preventDefault()
            var that = this
            if (!this.isShown) return
            this.isShown = false
            this.escape()
            $(document).off('custom')
            this.$element.removeClass('in').attr('aria-hidden', true)
            $.support.transition && this.$element.hasClass('fade') ? this.hideWithTransition() : this.hidebox()
        },
        enforceFocus: function () {
            var that = this
            $(document).on('custom', function (e) {
                if (that.$element[0] !== e.target && !that.$element.has(e.target).length) {
                	document.activeElement.blur();
                    that.$element.find('.callback-btn')[0].focus();
                }
            })
        },
        escape: function () {
            var that = this
            if (this.isShown && this.options.keyboard) {
                this.$element.on('keyup.dismiss.box', function ( e ) {
                    e.which == 27 && that.hide()
                })
            } else if (!this.isShown) {
                this.$element.off('keyup.dismiss.box')
            }
        },
        hideWithTransition: function () {
            var that = this
                , timeout = setTimeout(function () {
                    that.$element.off($.support.transition.end)
                    that.hidebox()
                }, 500)

            this.$element.one($.support.transition.end, function () {
                clearTimeout(timeout)
                that.hidebox()
            })
        },
        hidebox: function () {
            var that = this
            this.$element.hide()
            this.backdrop(function () {
                that.removeBackdrop()
                that.options.boxback(); // 触发回调函数
            })
        },
        removeBackdrop: function () {
            this.$backdrop && this.$backdrop.remove()
            this.$backdrop = null
        },
        backdrop: function (callback) {
            var that = this,
                animate = this.$element.hasClass('fade') ? 'fade' : ''
            if (this.isShown && this.options.backdrop) {
                var doAnimate = $.support.transition && animate
                this.$backdrop = $('<div class="box-backdrop ' + animate + '" />').appendTo(document.body)
                // this.$backdrop.click(
                //   this.options.backdrop == 'static' ?
                //     $.proxy(this.$element[0].focus, this.$element[0])
                //   : $.proxy(this.hide, this)
                // )
                if (doAnimate) this.$backdrop[0].offsetWidth // force reflow
                this.$backdrop.addClass('in')
                if (!callback) return
                doAnimate ? this.$backdrop.one($.support.transition.end, callback) : callback()
            } else if (!this.isShown && this.$backdrop) {
                this.$backdrop.removeClass('in')
                $.support.transition && this.$element.hasClass('fade')?
                    this.$backdrop.one($.support.transition.end, callback) :
                    callback()
            } else if (callback) {
                callback()
            }
        }
    }

    $.fn.box = function (option) {
        return this.each(function () {
            var $this = $(this), data = $this.data('box'),
                options = $.extend({}, $.fn.box.defaults, $this.data(), typeof option == 'object' && option)
            if (!data) $this.data('box', (data = new Box(this, options)))
            if (typeof option == 'string') data[option]()
            else if (options.show) data.show()
        })
    }
    $.fn.box.defaults = {
        backdrop: true,
        keyboard: false,
        show: true,
        boxback : function(){}
    }

    $.fn.box.Constructor = Box

})(jQuery);


// ALERT BOX
!(function($, window) {
    window.alert = function(str1, callback, lan) {
        str1 = str1 + "";
        str1 = str1.replace(/\</g, "&lt;");
        str1 = str1.replace(/\>/g, "&gt;");
        str1 = str1.replace(/\//g, "&#47;");
        if (typeof callback === "string") {lan = callback; callback = undefined;}
        callback = callback || (function() {});
        var _pageLan = $("html").attr("lang") || '';
        if (_pageLan.toUpperCase() == 'EN') lan = 'en';
        var $box = $("<div class='modal fade hide alert-box'><div class='modal-body'>" + str1 + "</div><div class='modal-footer'><button class='btn btn-warning callback-btn' type='button' data-dismiss='box'>" + ((lan && lan == "en") ? "OK" : "确定") + "</button></div></div>").appendTo(document.body)
        $box.box({boxback : function() {
            $box.remove(); setTimeout(callback, 400); $box = null;
        }}).box("show")
        // return str1; //不能有返回值
    };

    window.confirm = function(str2, callback, lan) {
        str2 = str2 + "";
        str2 = str2.replace(/\</g, "&lt;");
        str2 = str2.replace(/\>/g, "&gt;");
        str2 = str2.replace(/\//g, "&#47;");
        callback = callback || function() {};
        var _pageLan = $("html").attr("lang") || '';
        if (_pageLan.toUpperCase() == 'EN') lan = 'en';
        var $box = (lan && lan == "en") ? $("<div class='modal fade hide alert-box'><div class='modal-body'>" + str2 + "</div><div class='modal-footer'><button class='btn' type='button' data-dismiss='box'>No</button><button class='btn btn-warning callback-btn' type='button' data-dismiss='box'>Yes</button></div></div>") :
            $("<div class='modal fade hide alert-box'><div class='modal-body'>" + str2 + "</div><div class='modal-footer'><button class='btn btn-warning callback-btn' type='button' data-dismiss='box'>确定</button><button class='btn' type='button' data-dismiss='box'>取消</button></div></div>");
        $box.appendTo(document.body);
        $box.box({boxback : function() {$box.remove();}})
            .find(".callback-btn").one("click", function() {setTimeout(callback, 450);});
        // return str2;
    };


})(jQuery, window);
