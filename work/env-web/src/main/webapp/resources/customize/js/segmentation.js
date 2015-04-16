var Segmentation = function($) {
	// 千分位自动分位
	var segmentation = function(thisobj) {
		thisobj.value = thisobj.value.replace(/,/g, "");
		var re = /\d{1,3}(?=(\d{3})+$)/g;
		var n1 = thisobj.value.replace(/^(\d+)((\.\d+)?)$/,
				function(s, s1, s2) {
					return s1.replace(re, "$&,") + s2;
				});
		return n1;
	};

	// 根据按键输入值，判断是否改变文本框中的值
	var isChangeValue = function(event) {
		var keyCode = event.keyCode;
		
		var flag = false;
		// [48--57：数字0-9]、[96--105:小键盘数字0-9]、[8：删除键]、[46:delete键]、[13：回车键]
		if ((48 <= keyCode && keyCode <= 57)
				|| (96 <= keyCode && keyCode <= 105) || (keyCode == 8)
				|| (keyCode == 46) || (keyCode == 13)) {
			flag = true;
		}

		return flag;
	};

	return {
		// 千分位自动分位
		segmentation : function(obj) {
			return segmentation(obj);
		},
		// 根据按键输入值，判断是否改变文本框中的值
		isChangeValue : function(event) {
			return isChangeValue(event);
		}
	};
}(window.jQuery);
