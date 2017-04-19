var olanguage={
    "destroy": true,
    "bAutoWidth":false,
    "sPaginationType": "full_numbers",
    "aLengthMenu": [[5,10, 25, 50, -1], [5,10, 25, 50, "All"]], //每页显示数量下拉框
    "iDisplayLength": 5,  //每页显示数量
    "oLanguage": {
        "sLengthMenu": "每页显示 _MENU_ 条记录",
        "sZeroRecords": "抱歉， 没有找到",
        "sInfo": "从 _START_ 到 _END_ /共 _TOTAL_ 条数据",
        "sInfoEmpty": "没有数据",
        "sInfoFiltered": "(从 _MAX_ 条数据中检索)",
        "sZeroRecords": "没有检索到数据",
        "sSearch": "名称:",
        "oPaginate": {
            "sFirst": "首页",
            "sPrevious": "前一页",
            "sNext": "后一页",
            "sLast": "尾页"
        }
    }
};
//初始化页面上的dataTables
function init() {
    $(document).ready(function() {
        $('.table-bordered').dataTable({
            "destroy": true,
            "bAutoWidth":false,
            "sPaginationType": "full_numbers",
            "aLengthMenu": [[5,10, 25, 50, -1], [5,10, 25, 50, "All"]], //每页显示数量下拉框
            "iDisplayLength": 5,  //每页显示数量
            "oLanguage": {
                "sLengthMenu": "每页显示 _MENU_ 条记录",
                "sZeroRecords": "抱歉， 没有找到",
                "sInfo": "从 _START_ 到 _END_ /共 _TOTAL_ 条数据",
                "sInfoEmpty": "没有数据",
                "sInfoFiltered": "(从 _MAX_ 条数据中检索)",
                "sZeroRecords": "没有检索到数据",
                "sSearch": "名称:",
                "oPaginate": {
                    "sFirst": "首页",
                    "sPrevious": "前一页",
                    "sNext": "后一页",
                    "sLast": "尾页"
                }
            }
        });
    })
}
//清空数据，销毁实例
function reinit() {
    $(document).ready(function() {
        $('.table-bordered').DataTable().clear();
        $('.table-bordered').DataTable().fnDestroy();
    });
}