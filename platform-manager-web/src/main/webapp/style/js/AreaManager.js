var ie = navigator.appName == "Microsoft Internet Explorer" ? true : false;
var province = new Array();
var city=new Array();
var area=new Array();

function $get(objID) {
    return document.getElementById(objID);
}

var Memo = 1;              //Memo 参数控制省市区必须选择深度，参数可选值（1，2，3）: 1表示选择到省，2表示选择到市，3表示选择到区域
var cName, cID, tobj;
var p, c, a;
var showX = true;
var sl = false;
var fun=null;

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
    A += "<div id='province' class='citynamecityid' style='z-index:1999; position: absolute;  width: 377px; display:none; height: 204px; overflow:hidden;margin-left: 60px;'>";
    //if (ie) {
        A += "<iframe id='provinceFrame' hideFocus='true' frameborder='0' src='about:blank' style='position:absolute;z-index:-1;width:370px;height:185px;top:0px;left:0px;filter:progid:DXImageTransform.Microsoft.Alpha(opacity=0);'  allowtransparency='true'></iframe>";
    //}
    A += "<div id='provincecontent' style='width:370px; height:204px; overflow:hidden;z-index:99999;'>";

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

function showProvince(obj, cname, cid, level, showXICon, event, showall,func) {
    p = c = a = null;
    tobj = obj;
    //alert(cname + ";" + cid);
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


    retProvince();
    var pos = findPos(obj);

    $get('province').style.left = (parseInt(pos['x']) - 50) + "px";
    $get('province').style.top = (pos['y'] + obj.offsetHeight) + "px";
    $get('province').style.display = "block";

    cancelBubble(event);
    if (func){
    	fun = func;
    }
}

function retProvince() {
    var A = "<div class='box_bg'></div><div class='box_top'></div><div class='box_con'><div class='close_bar' style='height:11px;'>";
    if (showX == true)
        A += "<button id='btnClose' class='close' onclick='cancelBubble(event);closeCity();return false;'></button>";
    A += "</div>";
    if (sl == true)
        A += "<div class='c_link' style='padding:2px 3px;'><a class='selecthref' onfocus='this.blur();' href='#' onclick='javascript:cancelBubble(event);chooseChina();'>全&nbsp;&nbsp;国</a></div>";

    for (var B = 0; B < province.length / 3; B++) {
        A += "<div class='c_link'"
        if (sl == true)
            A += " style='padding:2px 3px;'";
        A += "><a class='selecthref'  onfocus='this.blur();' href='#' onclick='javascript:cancelBubble(event);showcity(" + B + ");'>" + province[B * 3] + "</a></div>"
    }


    A += "<div ><a class='clearplace' onfocus='this.blur();' href='#' onclick='javascript:cancelBubble(event);clearText();'>清&nbsp;&nbsp;空</a></div>"
    A += "<div class='clear'></div></div>";

    $get("provincecontent").innerHTML = A;
}

function showcity(C) {

    c = null;
    a = null;
    p = province[C * 3];

    var B = "<div class='box_bg'></div><div class='box_top'></div><div class='box_con'><div class='close_bar' style='height:11px;'>";
    if (showX == true)
        B += "<button class='close' onclick='cancelBubble(event);closeCity();return false;'></button>";

    B += "</div> <div class='c_link1 provTitle'><table width='70px'><tr height='25'><td valign='middle'><span class='provText'>" + province[C * 3] + "<br/></span></td></tr><tr><td>";
    if (Memo == 1) {
        B += "<a class='buttonhref' onfocus='this.blur();' href='#' onclick='javascript:cancelBubble(event);chooseplace(\"" + province[C * 3] + "\",\"" + province[C * 3 + 1] + "\");'>确定</a>";
    }
    B += "<br/><a class='buttonhref' onfocus='this.blur();' href='#' onclick='javascript:cancelBubble(event);retProvince();'>返回</a></td></tr></table></div>";

    for (var A = 0; A < city[C].length / 4; A++) {
        B += "<div class='c_link'><a class='selecthref' onfocus='this.blur();' href='#' onclick='javascript:cancelBubble(event);showarea(" + city[C][A * 4] + "," + A + "," + C + ");'>" + city[C][A * 4 + 1] + "</a></div>"
    }

    B += "<div class='clear'></div></div>";

    $get("provincecontent").innerHTML = B;
}


function showarea(D, ss, aa) {
    c = city[aa][ss * 4 + 1];
    var C = "<div class='box_bg'></div><div class='box_top'></div><div class='box_con'><div class='close_bar' style='height:11px;'>";
    if (showX == true)
        C += "<button class='close' onclick='cancelBubble(event);closeCity();return false;'></button>";
    C += "</div> <div class='c_link1 provTitle'><table width='70px'><tr height='24'><td valign='middle' align='center'><span class='provText'>" + city[aa][ss * 4 + 1] + "<br/></span></td></tr><tr><td>"
    if (Memo <= 2) {
        C += "<a class='buttonhref' onfocus='this.blur();' href='#' onclick='javascript:cancelBubble(event);chooseplace(\"" + city[aa][ss * 4 + 1] + "\",\"" + city[aa][ss * 4 + 2] + "\");'>确定</a>";
    }
    C += "<br/><a class='buttonhref' onfocus='this.blur();' href='#' onclick='javascript:cancelBubble(event);showcity(" + aa + ");'>返回</a></td></tr></table></div>";

    for (var G = 0; G < area[D].length / 3; G++) {
        C += "<div class='c_link'><a class='selecthref' onfocus='this.blur();' href='#' onclick='javascript:cancelBubble(event);chooseplace(\"" + area[D][G * 3] + "\",\"" + area[D][G * 3 + 1] + "\");'>" + area[D][G * 3] + "</a></div>"
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

    /*var cn = '';
    if (p) {
        cn = p;
        if (c) {
            cn = cn + "-" + c;
            if (a) {
                if (a != B)
                    cn = cn + "-" + B;
            }
            else {
                if (c != B) {
                    cn = cn + "-" + B;
                }
            }
        }
        else {
            if (cn != B)
                cn = cn + "-" + B;
        }
    }
    else {
        cn = B;
    }*/
    $get(cName).value = B;
    $get(cID).value = A;
    closeCity();
}
function closeCity() {
    $get("province").style.display = "none";
    if (fun){
    	eval(fun);
    }
}

function area_hide() {
    closeCity();
}

function clearText() {
    $get(cName).value = '';
    $get(cID).value = '';
    closeCity();
}

var areast = setTimeout(
    function() {
        loadProvince();
        clearTimeout(areast)
    }, 200
);