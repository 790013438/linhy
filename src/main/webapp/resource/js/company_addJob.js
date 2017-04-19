
$(function(){
    $("form").submit(function(e){
        e.preventDefault();
        saveJob();
    });

    $.fn.serializeJson=function(){
        var serializeObj={};
        var array=this.serializeArray();
        var str=this.serialize();
        $(array).each(function(){
            if(serializeObj[this.name]){
                if($.isArray(serializeObj[this.name])){
                    serializeObj[this.name].push(this.value);
                }else{
                    serializeObj[this.name]=[serializeObj[this.name],this.value];
                }
            }else{
                serializeObj[this.name]=this.value;
            }
        });
        return serializeObj;
    };
});
function saveJob() {
    var form=$("#formJob").serializeJson();
    form=JSON.stringify(form);
    console.log(form);
    var data={
        json:form
    };
    $.ajax({ //一个Ajax过程
        type: "post", //以post方式与后台沟通
        url :getRootPath()+"/user/register", //与此页面沟通
        dataType:'json',//返回的值以 JSON方式 解释
        data: data, //发给的数据
        success: function(json){//如果调用成功
            console.log(json);
            if(json.success== false){
                alert(json.error);
            }else {
                alert(json.error);
            }
        },
        error:function (json) {
            console.log(json);
            alert(json.error);
        }
    });
}



