var _appendObject;
var _this;
var _isTwoStage;
function SelCity(obj,e,appendObject,blodType) {
    _appendObject = appendObject||{};
    _this = obj;
    var _blodType = blodType||"city";
    _isTwoStage = _appendObject.isTwoStage||false;
    var ths = obj;
    var dal = '<div class="_citys">' +
                '<span title="确定" id="cChoose" >确定</span>' ;
    if (_blodType=='city'){
        dal += '<ul id="_citysheng" class="_citys0">' ;
        dal +=    '<li id="li-hproper" class="citySel">省份</li>' ;
        dal +=   '<li id="li-hcity">城市</li>' ;
        if(_isTwoStage==false){
        	dal +=    '<li id="li-harea">区县</li>' ;
        }
        dal +=    '</ul>' ;
        dal +=    '<div class="city-select-content">' ;
        dal +=    '<div id="_citys0" class="_citys1"></div>' ;
        dal +=    '<div style="display:none" id="_citys1" class="_citys1"></div>' ;
        if(_isTwoStage==false){
         	dal +=    '<div style="display:none" id="_citys2" class="_citys1"></div>' 
        }
        dal +=    '</div>' ;
    }else if (_blodType=='proType'){
        dal +=
            '<ul id="_citysheng" class="_citys0">' +
            '<li id="proType1" class="citySel">物资类别</li>' +
            '<li id="proType2"></li>' +
            '<li id="proType3"></li>' +
            '<li id="proType4"></li>' +
            '</ul>' +
            '<div class="city-select-content">' +
            '<div id="_citys0" class="_citys1"></div>' +
            '<div style="display:none" id="_citys1" class="_citys1"></div>' +
            '<div style="display:none" id="_citys2" class="_citys1"></div>' +
            '<div style="display:none" id="_citys3" class="_citys1"></div>' +
            '</div>' ;
    }
    dal += '</div>';
    if(_appendObject!=undefined&&_appendObject!=""&&_appendObject!=null){
    	Iput.show({ id: ths, event: e, content: dal,width:"470",positions:_appendObject.positions});
    }else{
    	Iput.show({ id: ths, event: e, content: dal,width:"470"});
    }
    $("#cChoose").click(function () {
        var _city = $(_this).val();
        if (_city){
            if (_city.split('-').length==2){
                $('#harea').remove();
            }
            if (_city.split('-').length==1){
                $('#harea').remove();
                $('#hcity').remove();
            }
        }
        Iput.colse();
    });
    var tb_province = [];
    var b = _blodType=='city'?province:p_level_1;
    _leftAbbr(tb_province,b);
    $("#_citys0").append(tb_province.join(""));
    addClass_AreaS();
    $("#_citys0").on ('click','a',function () {
        $('#hproper').remove();
        $('#hcity').remove();
        $('#harea').remove();
        //if (_blodType=='proType'){
        //    $('#proType2').html($(this).val());
        //}
        var g = getCity($(this));
        $("#_citys1 a").remove();
        $("#_citys1").append(g);
        $("._citys1").hide();
        $("._citys1:eq(1)").show();
        $("#_citys0 a,#_citys1 a,#_citys2 a").removeClass("AreaS");
        $(this).addClass("AreaS");
        var lev = $(this).data("name");
        ths.value = $(this).data("name");
        $(ths).attr('data-id',$(this).attr('data-id'));
        if (document.getElementById("hproper") == null) {
            var hcitys = $('<input>', {
                type: 'hidden',
                name: "hproper",
                "data-id": $(this).data("id"),
                id: "hproper",
                val: lev
            });
            $(ths).after(hcitys);
        }
        else {
            $("#hproper").val(lev);
            $("#hproper").attr("data-id", $(this).data("id"));
        }
        $("#_citys1").on('click','a',function(){
            citys1_on(ths,this);
        });
    });

    $("#_citysheng li").click(function () {
        $("#_citysheng li").removeClass("citySel");
        $(this).addClass("citySel");
        var s = $("#_citysheng li").index(this);
        var _id = $(this).attr('id');
        switch (_id){
            case 'li-hcity':
                if ($('#hproper').length!=0){
                    var g = getCity($('#hproper'));
                    $("#_citys1").html('');
                    $("#_citys1").append(g);
                    $("#_citys1").on('click','a',function(){
                        citys1_on(ths,this);
                    });
                    var _hcity = $('#hcity').attr('data-id');
                    if (_hcity) {
                        $('#hcity-'+_hcity).addClass('AreaS');
                    }
                }
                break;
            case 'li-harea':
                if ($('#hcity').length!=0){
                    var ar = getArea($('#hcity'));
                    $("#_citys2").html('');
                    $("#_citys2").append(ar);
                    $("#_citys2").on('click','a',function(){
                        citys2_on(ths,this);
                    });
                    var _harea = $('#harea').attr('data-id');
                    if (_harea) {
                        $('#harea-'+_harea).addClass('AreaS');
                    }
                }
                break;
        }
        $("._citys1").hide();
        $("._citys1:eq(" + s + ")").show();
    });
}

function citys1_on(ths,_this){
    $("#_citys1 a,#_citys2 a").removeClass("AreaS");
    $(_this).addClass("AreaS");
    var lev =  $(_this).data("name");
    if (document.getElementById("hcity") == null) {
        var hcitys = $('<input>', {
            type: 'hidden',
            name: "hcity",
            "data-id": $(_this).data("id"),
            id: "hcity",
            val: lev
        });
        $(ths).after(hcitys);
    }else {
        $("#hcity").attr("data-id", $(_this).data("id"));
        $("#hcity").val(lev);
    }
    var bc = $("#hproper").val();
    ths.value = bc+ "-" + $(_this).data("name");
    $(ths).attr('data-id',$("#hproper").attr('data-id')+"-"+$(_this).attr('data-id'));
    var ar = getArea($(_this));
    if(_isTwoStage==true){
		Iput.colse();
	}else{
	    $("#_citys2 a").remove();
	    $("#_citys2").append(ar);
	    $("._citys1").hide();
		$("._citys1:eq(2)").show();
		$("#_citys2").on('click','a',function(){
	        citys2_on(ths,this);
	    });
	}

    $("#_citys2").on('click','a',function(){
        citys2_on(ths,this);
    });
}

function citys2_on(ths,_this) {
    $("#_citys2 a").removeClass("AreaS");
    $(_this).addClass("AreaS");
    var lev = $(_this).data("name");
    if (document.getElementById("harea") == null) {
        var hcitys = $('<input>', {
            type: 'hidden',
            name: "harea",
            "data-id": $(_this).data("id"),
            id: "harea",
            val: lev
        });
        $(ths).after(hcitys);
    }else {
        $("#harea").val(lev);
        $("#harea").attr("data-id", $(_this).data("id"));
    }
    var bc = $("#hproper").val();
    var bp = $("#hcity").val();
    ths.value = bc + "-" + bp + "-" + $(_this).data("name");
    $(ths).attr('data-id',$("#hproper").attr('data-id')+"-"+$("#hcity").attr('data-id')+"-"+$(_this).attr('data-id'));
    Iput.colse();
};

function addClass_AreaS(){
    if ($('#hproper')) {
        var _hproper = $('#hproper').attr('data-id');
        if (_hproper) {
            $('#hproper-'+_hproper).addClass('AreaS');
        }
    }
}

function getCity(obj) {
    var c = obj.data('id');
    var e = province;
    var f;
    var g = '';
    for (var i = 0, plen = e.length; i < plen; i++) {
        if (e[i]['id'] == parseInt(c)) {
            f = e[i]['city'];
            break
        }
    }
    for (var j = 0, clen = f.length; j < clen; j++) {
        g += '<a class="c-city" id="hcity-'+f[j]['id']+'" data-level="1" data-id="' + f[j]['id'] + '" data-name="' + f[j]['name'] + '" title="' + f[j]['name'] + '">' + f[j]['name'] + '</a>'
    }
    $("#_citysheng li").removeClass("citySel");
    $("#_citysheng li:eq(1)").addClass("citySel");
    return g;
}
function getArea(obj) {
    //var c = obj.data('id');
    var c = obj[0].dataset.id;
    var e = area;
    var f = [];
    var g = '';
    for (var i = 0, plen = e.length; i < plen; i++) {
        if (e[i]['pid'] == parseInt(c)) {
            f.push(e[i]);
        }
    }
    for (var j = 0, clen = f.length; j < clen; j++) {
        g += '<a id="harea-'+f[j]['id']+'" data-level="1" data-id="' + f[j]['id'] + '" data-name="' + f[j]['name'] + '" title="' + f[j]['name'] + '">' + f[j]['name'] + '</a>'
    }

    $("#_citysheng li").removeClass("citySel");
    $("#_citysheng li:eq(2)").addClass("citySel");
    return g;
}

function _leftAbbr(tb_province,b){
    var _array = ['A-G','H-K','L-S','T-Z'];
    for (var k=0;k<_array.length;k++){
        tb_province.push('<dl><dt>'+_array[k]+'</dt><dd>');
        for (var i = 0, len = b.length; i < len; i++) {
            if (k==0&&b[i]['index']>='A'&&b[i]['index']<='G'){
                tb_province.push('<a id="hproper-'+b[i]['id']+'" data-level="0" data-id="' + b[i]['id'] + '" data-name="' + b[i]['name'] + '">' + b[i]['name'] + '</a>');
            }
            if (k==1&&b[i]['index']>='H'&&b[i]['index']<='K'){
                tb_province.push('<a id="hproper-'+b[i]['id']+'" data-level="0" data-id="' + b[i]['id'] + '" data-name="' + b[i]['name'] + '">' + b[i]['name'] + '</a>');
            }
            if (k==2&&b[i]['index']>='L'&&b[i]['index']<='S'){
                tb_province.push('<a id="hproper-'+b[i]['id']+'" data-level="0" data-id="' + b[i]['id'] + '" data-name="' + b[i]['name'] + '">' + b[i]['name'] + '</a>');
            }
            if (k==3&&b[i]['index']>='T'&&b[i]['index']<='Z'){
                tb_province.push('<a id="hproper-'+b[i]['id']+'" data-level="0" data-id="' + b[i]['id'] + '" data-name="' + b[i]['name'] + '">' + b[i]['name'] + '</a>');
            }
        }
        tb_province.push('</dd></dl>');
    }
}