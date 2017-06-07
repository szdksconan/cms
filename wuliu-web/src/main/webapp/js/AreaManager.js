var ie = navigator.appName == "Microsoft Internet Explorer" ? true : false;
function $get(objID) {
    return document.getElementById(objID);
}
var province = new Array();
var city={};
var area={};

var Memo = 1;              //Memo 参数控制省市区必须选择深度，参数可选值（1，2，3）: 1表示选择到省，2表示选择到市，3表示选择到区域
var cName, cID, tobj,_did;
var p, c, a,_provinceAreaId;
var pid,cityid;
var showX = true;
var sl = false;
var flag=true;//是否返回所有id

function findPos(obj) {
    var r = new Array();
    r['x'] = obj.offsetLeft;
    r['y'] = obj.offsetTop;
    while (obj = obj.offsetParent) {
        r['x'] += obj.offsetLeft;
        r['y'] += obj.offsetTop;
    }
    return r;
}

function cancelBubble(event) {
    e = event ? event : window.event;
    if (ie) {
        window.event.cancelBubble = true;
        window.event.returnValue = false;
    } else {
        e.preventDefault();
        e.stopPropagation();
    }
    return false;
}

function loadProvince() {
    var A = '';
    A += "<div id='province' class='citynamecityid' style='z-index:9999; position: absolute;  width: 377px; display:none; height: 204px; overflow:hidden;'>";
    //if (ie) {
        A += "<iframe id='provinceFrame' hideFocus='true' frameborder='0' src='about:blank' style='position:absolute;z-index:-1;width:370px;height:185px;top:0px;left:0px;filter:progid:DXImageTransform.Microsoft.Alpha(opacity=0);'  allowtransparency='true'></iframe>";
    //}
    A += "<div id='provincecontent' style='width:370px; height:204px; overflow:hidden;'>";

    A += "</div>";
    A += "</div>";

    var pelement = document.createElement("div");
    pelement.innerHTML = A;

    var t = document.getElementsByTagName("body")[0];
    t.appendChild(pelement);



    if (ie) {
        document.body.attachEvent("onclick", function(event) {
            $get('province').style.display = 'none';

        });
    }
    else {
        document.body.addEventListener("click", function(event) {
            $get('province').style.display = 'none';
        }, false);

    }

    $get('provincecontent').onclick = function(event) {
        cancelBubble(event);
    }

}

function showProvince(obj, cname, cid, level, showXICon, event, showall,flag,did) {
    p = c = a = null;
    pid=cityid=null;
    tobj = obj;
    _did=did;
    if (cname)
        cName = cname;

    if (cid)
        cID = cid;

    if (level != 'undefined' && level != null)
        Memo = level;

    if (showXICon != 'undefined' && showXICon != null)
        showX = showXICon;

    if (showall != 'undefined' && showall != null)
        sl = showall;

    if (flag==false){
    	this.flag=flag
    }
    retProvince();
    var pos = findPos(obj);

    $get('province').style.left = (parseInt(pos['x']) - 50) + "px";
    $get('province').style.top = (pos['y'] + obj.offsetHeight) + "px";
    $get('province').style.display = "block";

    cancelBubble(event);
}

function retProvince() {
    var A = "<div class='box_bg'></div><div class='box_top'></div><div class='box_con'><div class='close_bar' style='height:11px;'>";
    if (showX == true)
        A += "<button id='btnClose' class='close' onclick='cancelBubble(event);closeCity();return false;'></button>";
    A += "</div>";
    if (sl == true)
        A += "<div class='c_link' style='padding:2px 3px;'><a class='selecthref' onfocus='this.blur();' href='#' onclick='javascript:cancelBubble(event);chooseChina();'>全&nbsp;&nbsp;国</a></div>";

    for (var B = 0; B < province.length; B++) {
        A += "<div class='c_link'"
        if (sl == true)
            A += " style='padding:2px 3px;'";
        A += "><a class='selecthref'  onfocus='this.blur();' href='#' onclick='javascript:cancelBubble(event);showcity(\"" + province[B].id + "\",\""+province[B].name+"\",\""+province[B].provinceAreaId+"\");'>" + province[B].name + "</a></div>"
    }


    A += "<div class='c_link'><a class='clearplace' onfocus='this.blur();' href='#' onclick='javascript:cancelBubble(event);clearText();'>清&nbsp;&nbsp;空</a></div>"
    A += "<div class='clear'></div></div>";

    $get("provincecontent").innerHTML = A;
}

function showcity(C,pname,provinceAreaId) {

    c = null;
    a = null;
    p = pname;
    _provinceAreaId = provinceAreaId;
    cityid=null;
    pid=C;

    var B = "<div class='box_bg'></div><div class='box_top'></div><div class='box_con'><div class='close_bar' style='height:11px;'>";
    if (showX == true)
        B += "<button class='close' onclick='cancelBubble(event);closeCity();return false;'></button>";

    B += "</div> <div class='c_link1 provTitle'><table width='70px'><tr height='25'><td valign='middle'><span class='provText'>" + pname + "<br/></span></td></tr><tr><td>";
    if (Memo == 1) {
        B += "<a class='buttonhref' onfocus='this.blur();' href='#' onclick='javascript:cancelBubble(event);chooseplace(\"" + pname + "\",\"" + C + "\");'>确定</a>";
    }
    B += "<br/><a class='buttonhref' onfocus='this.blur();' href='#' onclick='javascript:cancelBubble(event);retProvince();'>返回</a></td></tr></table></div>";
    var ids = city[C].ids.split(',');
    var names = city[C].names.split(',');
    for (var A = 0; A < ids.length ; A++) {
        B += "<div class='c_link'><a class='selecthref' onfocus='this.blur();' href='#' onclick='javascript:cancelBubble(event);showarea(\"" + ids[A]+ "\",\"" + names[A] + "\",\"" + ids[A] + "\");'>" + names[A] + "</a></div>"
    }

    B += "<div class='clear'></div></div>";

    $get("provincecontent").innerHTML = B;
}


function showarea(D, cname, aa) {
    c = cname;
    cityid = D;
    var C = "<div class='box_bg'></div><div class='box_top'></div><div class='box_con'><div class='close_bar' style='height:11px;'>";
    if (showX == true)
        C += "<button class='close' onclick='cancelBubble(event);closeCity();return false;'></button>";
    C += "</div> <div class='c_link1 provTitle'><table width='70px'><tr height='24'><td valign='middle' align='center'><span class='provText'>" + cname + "<br/></span></td></tr><tr><td>"
    if (Memo <= 2) {
        C += "<a class='buttonhref' onfocus='this.blur();' href='#' onclick='javascript:cancelBubble(event);chooseplace(\"" + cname + "\",\"" + D + "\");'>确定</a>";
    }
    C += "<br/><a class='buttonhref' onfocus='this.blur();' href='#' onclick='javascript:cancelBubble(event);showcity(\"" + pid + "\",\""+p+"\");'>返回</a></td></tr></table></div>";
    if (area[D]){
    	var ids = area[D].ids.split(',');
        var names = area[D].names.split(',');
        for (var G = 0; G < ids.length ; G++) {
            C += "<div class='c_link'><a class='selecthref' onfocus='this.blur();' href='#' onclick='javascript:cancelBubble(event);chooseplace(\"" + names[G] + "\",\"" + ids[G] + "\");'>" + names[G] + "</a></div>"
        }
    }
    C += "<div class='clear'></div></div>";
    $get("provincecontent").innerHTML = C;
}

function chooseChina() {
    $get(cName).value = '全国';
    $get(cID).value = '000000';
    closeCity();
}

function chooseplace(B, A) {

    var cn = '';
    var idval = '';
    if (p) {
        cn = p;
        idval = pid;
        if (c) {
            cn = cn + "-" + c;
            idval = idval + '-' + cityid;
            if (a) {
                if (a != B){
                	cn = cn + "-" + B;
                	idval = idval + '-' + A;
                }
            }
            else {
                if (c != B) {
                    cn = cn + "-" + B;
                    idval = idval + '-' + A;
                }
            }
        }
        else {
            if (cn != B){
            	cn = cn + "-" + B;
                idval = idval + '-' + A;
            }
        }
    }
    else {
        cn = B;
    }
    if (flag){
    	$get(cID).value = idval;
    }else {
    	$get(cID).value = A;
    }
    $get(cName).value = cn;
    if (_did){
        $get(_did).value=_provinceAreaId;
    }
    closeCity();
}
function closeCity() {
    $get("province").style.display = "none";
}

function area_hide() {
    closeCity();
}

function clearText() {
    $get(cName).value = '';
    $get(cID).value = '';
    closeCity();
}

function checkValue(th){
	if (th.value==''){
		clearText();
	}
}

var areast = setTimeout(
    function() {
        loadProvince();
        clearTimeout(areast);
    }, 1000
);