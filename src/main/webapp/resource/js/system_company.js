
$(function(){
    $('.menu-list').removeClass('active open');
    $('.submenu').find('li').removeClass('active open');
    $("#systemCompany").addClass('active open');
    getCompanyList();
    $("#btnFrozen").click(function () {
        closepop();
        var companyId = $("#companyId").val();
        var condition = {
            companyId:companyId,
            compStatus:'comp_frozen'
        };
        updateCompStatus(condition);
    });
    $("#btnThaw").click(function () {
        closepop();
        var companyId = $("#companyId").val();
        var condition = {
            companyId:companyId,
            compStatus:'comp_successful'
        };
        updateCompStatus(condition);
    });
    $("#btnAuditAgree").click(function () {
        closepop();
        var companyId = $("#companyId").val();
        var condition = {
            companyId:companyId,
            compStatus:'comp_successful'
        };
        updateCompStatus(condition);
    });
    $("#btnAuditRefuse").click(function () {
        closepop();
        var companyId = $("#companyId").val();
        var condition = {
            companyId:companyId,
            compStatus:'comp_refused'
        };
        updateCompStatus(condition);
    });
});

//查询用户列表
var getCompanyList = function() {
    $.ajax({
        url:"../admin/getAllCompany",
        type : 'post',
        data : null,
        dataType : 'json',
        success:function(result){
            if (result.success == true) {
                if (result.error != "") {
                    alert(result.error);
                    $("#table_company tbody").empty();
                    return;
                }
                if (result.data!=null){
                    console.log(result.data);
                    $("#table_company tbody").empty();
                    $.each(result.data, function (index, obj) {
                        var tr = appendCompanyNode(obj);
                        $("#table_company tbody").append(tr);
                        appendTabTitleById("table_company");
                    });
                    $(document).ready(function(){
                        $('#table_company').DataTable();
                    });
                } else{
                    $("#table_company tbody").empty();
                    var txt = "没有查询到符合条件的信息";
                    alert(txt);
                    return;
                }
            } else {
                //还得先清空所有行
                var txt = result.error;
                alert(txt);
                return;
            }
        },
        error : function(obj, msg) {
            //还得先清空所有行
            $("#table_company tbody").empty();
            var txt = "没有查询到符合条件的信息";
            alert(txt);
            return;
        },
    });
}

//修改企业状态
var updateCompStatus = function(data) {
    $.ajax({
        url:"../admin/updateCompanyStatus",
        type : 'post',
        data :data,
        dataType : 'json',
        success:function(result){
            console.log(result);
            if (result.success == true) {
                if (result.error != "") {
                    alert(result.error);
                    return;
                }else{
                    var txt = "修改企业状态成功";
                    alert(txt);
                    return;
                }
            } else {
                //还得先清空所有行
                var txt = result.error;
                alert(txt);
                return;
            }
        },
        error : function(obj, msg) {
            var txt = "修改企业状态失败";
            alert(txt);
            return;
        },
        complete: function () {
            getCompanyList();
        }
    });
}

$(".table tr td input").each(function(){
    $(this).attr("title",$(this).val());
});
/**
 * 传入要实现table的Id即可
 * @param id
 */
var appendTabTitleById = function(id)
{
    var cellIndex = parseInt ($ ("#" + id + ".table th").length) - 1;
    $ ($ ("#" + id + ".table tr td")).each (function ()
    {
        if (this.cellIndex != cellIndex)
        {
            $ (this).attr ("title", $ (this).text ());
        }
    });
    $ ("#" + id + ".table tr td input").each (function ()
    {
        $ (this).attr ("title", $ (this).val ());
    });
}
/**
 * 将td的内容(包括td下input)赋值给其title属性。
 * 配合max样式使用
 */
var appendTabTitle = function()
{
    $ (".table tr td").each (function ()
    {
        if ($ (this).parent ().attr ('class') != 'last_tr')
        { //有操作按钮的一栏不添加 title 属性
            if ($ (this).children ("select").length <= 0)
            {
                $ (this).attr ("title", $ (this).text ());
            }
        }
    });
}



var appendCompanyNode = function(obj) {
    var user_str = "<tr>"+
            "<td>"+obj.compAccount+"</td>"+
            "<td> "+obj.compStatus+"</td>"+
            "<td> "+obj.compContacts+"</td>"+
            "<td> "+obj.compPhone+"</td>"+
    "<td> "+obj.compEmail+"</td>"+
    "<td> "+obj.commWebsite+"</td>"+
    "<td> "+obj.compAddress+"</td>"+
            "<td>"+
            "<a  href =\"../system/company_showinfo?companyId="+obj.id+"\" >查看企业信息</a> |";
    if(obj.compStatus == '禁用'){
        user_str =user_str+ "<button type=\"button\" onclick=\"thawCompany('"+obj.id+"')\" class='btn btn-link'>解禁</button>";
    }else if(obj.compStatus =='注册成功'){
        user_str = user_str+"<button type=\"button\" onclick=\"frozenCompany('"+obj.id+"')\" class='btn btn-link'>禁用</button>";
    }
    if(obj.compStatus == '申请注册'){
        user_str =user_str+ "<button type=\"button\" onclick=\" AuditCompany('"+obj.id+"')\" class='btn btn-link'>审核</button>";
    }else{
        user_str = user_str+"<button type=\"button\" disabled='disabled'  class='btn btn-link'>审核</button>";
    }
    user_str=user_str+"<input type=\"hidden\" name=\"job_id\" value=\""+obj.id+"\"></td></tr>";
    return user_str;
}
function frozenCompany(data)
{
    $("#companyId").val(data);
    $(".pop").show();
    $("#popinto_frozen").show();
}
function thawCompany(data)
{
    $("#companyId").val(data);
    $(".pop").show();
    $("#popinto_thaw").show();
}

function AuditCompany(data)
{
    $("#companyId").val(data);
    $(".pop").show();
    $("#popinto_audit").show();
}





