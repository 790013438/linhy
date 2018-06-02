// var jy=document.getElementById('jy').value;/*讲义*/
// var kj=document.getElementById('kj').value;/*课件*/
// var lx=document.getElementById('lx').value;/*录像*/
// var jc=document.getElementById('jc').value;/*教材*/
// var zds=document.getElementById('zds').value;;/*指导书*/
// var rj=document.getElementById('rj').value;/*软件*/
// var dm=document.getElementById('dm').value;;/*代码*/
// console.log("全局"+jy+kj+lx+jc+zds+rj+dm);

/*/!*基于准备好的dom，初始化echarts实例*!/
var myChart=echarts.init(document.getElementById('main'));
/!*指定图表的配置项和数据*!/
var option={
    title:{text:'资源类型'},
    tooltip:{},
    legend:{
        data:['数量']
    },
    xAxis:{
        data:['讲义','课件','录像','教材','指导书','软件','代码']
    },
    yAxis:{},
    series:[{
        name:'数量',
        type:'bar',
        data:[jy,kj,lx,jc,zds,rj,dm]
    }]
};
/!*使用指上面方法指定的配置和数据显示图表*!/
myChart.setOption(option);*/


var myChart = echarts.init(document.getElementById('main'));

$.get('../admin/getNumber').done(function (result) {
    myChart.setOption({
        title: {
            text: '资源类型'
        },
        tooltip: {},
        legend: {
            data:['数量']
        },
        xAxis: {
            data: ['讲义','课件','录像','教材','指导书','软件','代码']
        },
        yAxis: {},
        series: [{
            name: '数量',
            type: 'bar',
            data: [result.data.jiangyi, result.data.kj, result.data.lx, result.data.jc, result.data.zds, result.data.rj,result.data.dm]
        }]
    });
});

