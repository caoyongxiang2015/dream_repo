var nn = nn || {};

// 导航下拉菜单
nn.dropMenu = function(){
	var timer;
	$(".dropdown-toggle").mouseleave(function(){
		var _this = $(this);
		timer = setTimeout(function(){
			_this.next().hide()
		}, 200);
	})
	$(".dropdown-toggle").mouseenter(function(){
		clearTimeout(timer);
		$(this).next().show();
	})
	$(".dropdown-menu").mouseleave(function(){
		var _this = $(this);
		timer = setTimeout(function(){
			_this.hide()
		}, 200);
	})
	$(".dropdown-menu").mouseenter(function(){
		clearTimeout(timer);
		$(this).show();
	})
}

// 登录注册框
nn.loginForm = function(){
	if (!$(".user-form")) {
		return;
	}
	$(".user-form").on("click",".J-gotologin",function(){
		$(".regidit-form").hide();
		$(".login-form").show();
	}).on("click",".J-gotoregidit",function(){
		$(".regidit-form").show();
		$(".login-form").hide();
	})
}

// 私信展开与合并
nn.expandMessage = function() {
	$(".privite-message").on("click",".panel-heading",function(){
		if ($(this).find("i").hasClass("glyphicon-resize-full")) {
			$(this).find("i").removeClass("glyphicon-resize-full").addClass("glyphicon-resize-small");
			$(this).removeClass("no-bottom-border");
			$(this).next().show();
		} else {
			$(this).find("i").removeClass("glyphicon-resize-small").addClass("glyphicon-resize-full");
			$(this).addClass("no-bottom-border");
			$(this).next().hide();
		}
		nn.footerFixed();
	})
}

// 底部版权的fixed定位
nn.footerFixed = function() {
	var _sh = document.body.clientHeight + 85;
	var _wh = $(window).height();
	//console.log("body: " + _sh+',-----,window:' + _wh)
	if (_sh<_wh) {
		$("body").addClass("body-fixed-bottom");
		$(".footer").addClass("navbar-fixed-bottom");
	} else {
		$("body").removeClass("body-fixed-bottom");
		$(".footer").removeClass("navbar-fixed-bottom");
	}
}

// 评分
nn.markScore = function() {
	$(".mark-stars").on("mouseenter",'i',function(){
		var _i = $(this).index();
		if (!$(this).hasClass("selected")) {
			for (var i = 0;i<=_i;i++) {
				$(".mark-stars i").eq(i).addClass("hover")
			}
			$(".J-score").text(_i + 1 +'分').show();
		}
	}).on("mouseleave","i",function(){
		$(".mark-stars i").removeClass("hover")
	}).on("click","i",function(){
		var _i = $(this).index();
		$(".mark-stars i").removeClass("selected")
		for (var i = 0;i<=_i;i++) {
			$(".mark-stars i").eq(i).addClass("selected")
		}
		$(".J-score").text(_i + 1 +'分').show();
	})
}

// 提交反馈
nn.complainResult = function(flag,data){
	// 回调此函数 nn.complainResult(flag,data),反馈发送投诉状态
	// falg: {boolean} 发送状态
	// data: {string} 发送返回文字
	if (flag) {
		$(".complain-result .alert").removeClass("alert-error").addClass("alert-success")
	} else {
		$(".complain-result .alert").removeClass("alert-success").addClass("alert-danger")
	}
	$(".complain-result").stop(true,true).fadeIn('fast').delay(2000).fadeOut('slow').children().text(data);
}

// 私信发送反馈
nn.returnStatus = function(data){
	// data: {string} 反馈文字
	setTimeout(function(){
		$("#returnStatus").modal("show");
		$("#returnStatus .modal-body").html(data)
	}, 1000);

}

// 选择公司领域
nn.selectArea = function(c,o) {
	var _area = [];
	o.on("blur",function(){
		_area = []
		_inputV = o.val();
		if (_inputV) {
			_area = o.val().split("，") // 此处约定使用中文的逗号分隔
		}
	})
	c.on("click","button",function(){
		var _v = $(this).text();
		if (_area.indexOf(_v)>=0) {
			return;
		}
		_area.push(_v);
		var _areaList = _area.join('，');	 // 此处约定使用中文的逗号分隔
		o.val(_areaList)
	})
}

$(function(){
	nn.dropMenu();
	nn.loginForm();
	nn.expandMessage();
	nn.footerFixed();
	nn.markScore();
	nn.selectArea($("#labelCollect01"),$("#companyCatagory01"));
	nn.selectArea($("#labelCollect02"),$("#companyCatagory02"));
	$(window).resize(function(){
		nn.footerFixed();
	})
})
