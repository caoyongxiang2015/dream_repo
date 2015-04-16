$(function () {
	initCascadeSelect();
    initCountryProvCityArea();
    initCountryCityPort();
});

function ajaxJSONReq(url, data, doneCallback) {
    $.ajax({
        url: url,
        type: "POST",
        cache: false,
        dataType: "json",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(data)
    }).done(function (data) {
            if (doneCallback) {
                doneCallback(data);
            }
        }
    );
}

function initCascadeSelect(){
	$("select").change(function(){
		var $this = $(this);
		var cascade = $this.attr("cascade");
		if( null != cascade ){
			var thisValue = $this.val();
			var $cascadeSelect = $("select[name='"+cascade+"']");
			var reloadUrl = $cascadeSelect.attr("reloadUrl");
			if( null != reloadUrl ){
				ajaxJSONReq(ctx + "/"+reloadUrl+"/" + thisValue, null, function (data) {
		            $cascadeSelect.empty();
		            for (var i = 0; i < data.length; i++) {
		                var item = data[i];
		                $cascadeSelect.append("<option value=\"" + item.code + "\">" + item.cnName + "</option>");
		            }
		            refreshChosen($cascadeSelect);
		            $cascadeSelect.trigger("change");
		        });
			}
		}
	});
}


function initCountryProvCityArea() {
    var parent = "div.country-prov-city-area";
    var parentSel = arguments.length > 0 ? arguments[0] : null;
    if (parentSel != null) {
        parent = $(parent, parentSel);
    }

    //$("select.country-select", parent).chosen().change(function () {
    $("select.country-select", parent).change(function () {
        var $this = $(this);
        var countryId = $this.val();
        
        var $prov = $("select.prov-select", $this.parent("div"));
        var $city = $("select.city-select", $this.parent("div"));
        var $area = $("select.area-select", $this.parent("div"));

        $prov.empty();
        //$city.empty();
        //$area.empty();
        //alert('countryId.html()='+$this.html());
        if(countryId){
            ajaxJSONReq(ctx + "/uim/getProvincesJSON/" + countryId, null, function (data) {
                var selectedProvCode = $prov.data("prov-code");

                if(selectedProvCode == -1){
                	$prov.append("<option selected=\"selected\"></option>");
                	$prov.data("prov-code","");
                }else{
                	$prov.append("<option ></option>");
                }
                
                //alert('data.length='+data.length);
                for (var i = 0; i < data.length; i++) {
                    var prov = data[i];
                    
                    if (prov.code == selectedProvCode) {
                        $prov.append("<option value=\"" + prov.code + "\" selected=\"selected\">" + prov.cnName + "</option>");
                    } else {
                        $prov.append("<option value=\"" + prov.code + "\">" + prov.cnName + "</option>");
                    }
                }

                //alert('$prov.html()='+$prov.html());
                $prov.trigger("liszt:updated");
                $prov.trigger("change");
            });        	
        }else{
        	$prov.append("<option selected=\"selected\"></option>");
        	$prov.data("prov-code","");
            $prov.trigger("liszt:updated");
            $prov.trigger("change");       	
        }
    });
    
    //alert('11111122222'+parent);

    $("select.country-select", parent).each(function () {
        var $country = $(this);
        //alert('$country.val()='+$country.val());
       // if (!$.isEmptyObject($country.val())) {
        if($country.val()){
        	//alert(22);
            $country.trigger("change");
        }
    });

    //update by nirui remove method isEmptyObject
    //$("select.prov-select", parent).chosen().change(function () {
    $("select.prov-select", parent).change(function () {
    	//alert("prov_change_update_city11");
        var $this = $(this);
        var provCode = $this.val();
        //if (!$.isEmptyObject(provCode)) {
        var $city = $("select.city-select", $this.parent("div"));
        var $area = $("select.area-select", $this.parent("div"));
        $city.empty();
        $area.empty();
        //alert(provCode);
        if(provCode){
        	//alert("prov_change_update_city2:"+provCode);
            ajaxJSONReq(ctx + "/uim/getCitiesJSON/" + provCode, null, function (data) {

                var selectedCityCode = $city.data("city-code");
                //console.log("selectedCityCode="+selectedCityCode);
                if(selectedCityCode == -1){
                	$city.append("<option selected=\"selected\"></option>");
                	$city.data("city-code","");
                }else{
                	$city.append("<option ></option>");
                }               
                for (var i = 0; i < data.length; i++) {
                    var city = data[i];
                    
                    if (city.code == selectedCityCode) {
                        $city.append("<option value=\"" + city.code + "\" selected=\"selected\">" + city.cnName + "</option>");
                    } else {
                        $city.append("<option value=\"" + city.code + "\">" + city.cnName + "</option>");
                    }
                }

                $city.trigger("liszt:updated");
                $city.trigger("change"); 
            });
        }else{
        	$city.append("<option selected=\"selected\"></option>");
        	$city.data("city-code","");
            $city.trigger("liszt:updated");
            $city.trigger("change");        	
        }

    });

    //$("select.city-select", parent).chosen().change(function () {
    $("select.city-select", parent).change(function () {
    	//alert("city_change_update_Area1:");
        var $this = $(this);
        var cityCode = $this.val();
        var $area = $("select.area-select", $this.parent("div"));
        $area.empty();
        //if (!$.isEmptyObject(cityCode)) {
        if(cityCode){
            ajaxJSONReq(ctx + "/uim/getAreasJSON/" + cityCode, null, function (data) {
                var selectedAreaCode = $area.data("area-code");
                //add by nirui : add default value
                //console.log("selectedAreaCode="+selectedAreaCode);
                if(selectedAreaCode == -1){
                	$area.append("<option selected=\"selected\"></option>");
                	$area.data("area-code","");
                }else{
                	$area.append("<option ></option>");
                }
                for (var i = 0; i < data.length; i++) {
                    var area = data[i];
                    
                    if (area.code == selectedAreaCode) {
                        $area.append("<option value=\"" + area.code + "\" selected=\"selected\">" + area.cnName + "</option>");
                    } else {
                        $area.append("<option value=\"" + area.code + "\">" + area.cnName + "</option>");
                    }
                }
                $area.trigger("liszt:updated");
            });
        }else{
        	$area.append("<option selected=\"selected\"></option>");
        	$area.data("area-code","");
        	$area.trigger("liszt:updated");
        }
    });
}


function initCountryCityPort() {
    var parent = "div.country-city-port";
    var parentSel = arguments.length > 0 ? arguments[0] : null;
    if (parentSel != null) {
        parent = $(parent, parentSel);
    }
    //$("select.city-select", parent).chosen().change(function () {
    $("select.city-select", parent).change(function () {
        var $this = $(this);
        var cityCode = $this.val();
        var $port = $("select.port-select", $this.parent("div"));
        var category = $port.data("port-category");
        if(!category){
        	category = "";
        }
        $port.empty();
        if(cityCode){
		 	$.ajax({
				url:ctx + "/uim/getPortsJSONByCityCodeAndCategory",
				type:'post',
				data:'cityCode='+cityCode+'&category='+category,
				success: function (data) {
		            var selectedPortId = $port.data("port-id");
		            if(selectedPortId == -1){
		            	$port.append("<option selected=\"selected\"></option>");
		            	$port.data("port-id","");
		            }else{
		            	$port.append("<option ></option>");
		            }		            
		            for (var i = 0; i < data.length; i++) {
		                var port = data[i];
		                if (port.id == selectedPortId) {
		                    $port.append("<option value=\"" + port.id + "\" selected=\"selected\">" + port.cnName + "</option>");
		                } else {
		                    $port.append("<option value=\"" + port.id + "\">" + port.cnName + "</option>");
		                }
		            }

		            $port.trigger("liszt:updated");
				}
			});
        }else{
        	$port.empty();
        	$port.append("<option ></option>");
        	$port.data("port-id","");
        	$port.trigger("liszt:updated");
        }
    });
    
    $("select.country-select", parent).chosen().change(function () {
    //$("select.country-select", parent).change(function () {
    	
        var $this = $(this);
        var countryId = $this.val();
        var $city = $("select.city-select", $this.parent("div"));
        var $port = $("select.port-select", $this.parent("div"));
        $city.empty();
        //$port.empty();
        if(countryId){
	        ajaxJSONReq(ctx + "/uim/getCitiesJSONByCountryId/" + countryId, null, function (data) {
	            var selectedCityCode = $city.data("city-code");
	            
	            if(selectedCityCode == -1){
	            	$city.append("<option selected=\"selected\"></option>");
	            	$city.data("city-code","");
	            }else{
	            	$city.append("<option ></option>");
	            }	 
	            for (var i = 0; i < data.length; i++) {
	                var city = data[i];
	                if (city.code == selectedCityCode) {
	                    $city.append("<option value=\"" + city.code + "\" selected=\"selected\">" + city.cnName + "</option>");
	                } else {
	                    $city.append("<option value=\"" + city.code + "\">" + city.cnName + "</option>");
	                }
	            }

	            $city.trigger("liszt:updated");
	            $city.trigger("change");
	        });
        }else{
        	//城市必选没有叉号
        	//$city.append("<option ></option>");
        	$city.data("city-code","");
            $city.trigger("liszt:updated");
            $city.trigger("change");        	
        }
    });
    

    $("select.country-select", parent).each(function () {
    	var $country = $(this);
        if ($country.val()!==undefined) {
            $country.trigger("change");
        }
    });
    

}

