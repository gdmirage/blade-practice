<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html;charset=utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<title>Brandslink</title>
<style>
*{padding: 0; margin: 0;font-size: 12px;color: #333}
.c666{color:#666;}
.fs85{font-size: 12px;}
table{width: 100%;border-collapse: collapse;}
.wrap{margin: 0px auto; width: 850px; overflow: hidden;}
.receipt-head { overflow: hidden;margin-bottom: 10px;}
.receipt-head img{float: left;margin-top:-21px;height: 22px;}
.receipt-head p{float: right;margin-top: -14px;font-size: 12px;}
.tc{text-align: center}
.rh-title{ font-size: 14px;margin-top: 15px; color: #212121;font-weight: bold;}
.receipt-table{margin-top: 5px; border: 1px solid #ddd;}
.receipt-table td{border-bottom: 1px solid #ddd;padding: 10px;font-size: 12px;}
.order-table{}
.order-table th{ background: #eee; text-align: left;padding: 10px; color: #666}
.order-table td{ padding: 10px;}
.stripe{background-color: #f4f4f4;}
.foot-table{ margin: 20px 0; font-size: 14px;}
.foot-table td{color:#666}
.sum{color:#E71F19}
.sum b{font-size: 14px;color:#E71F19;font-weight: normal}
.entxt{font-size: 12px;}
.receipt-table .people{font-weight: bold;font-size: 12px;}
.people .entxt{ position: relative;}
.people .entxt::before{    content: "";
    width: 2px;
    height: 18px;
    background: #666;
    position: absolute;
    left: -6px;
    top: -16px;}
.widthT{ width: 150px;}	
.foot-table{ font-size: 12px;}
.gz{ float: right; width: 300px;color: #666;margin-top: 6px;}
body {
	font-family: simsun;
	font-size: 14px;
	line-height: 1.6;
}
</style>
</head>
<body>
<div class="wrap">
	<div class="receipt-head">
		<div class="tc rh-title">商　业　发　票</div>
		<img src="https://brandslink.com/img/logoA.png">
		<p><span class="c666 fs85">发票开具日期：</span></p>
	</div>
	<table class="receipt-table">
		<tr>
			<td class="widthT c666">付款申请单号：</td>
			<td></td>
			<td class="c666">结算周期：</td>
			<td></td>
		</tr>
		<tr>
			<td colspan="4" class="people">发货人（全称和地址）<p class="entxt"></p></td>
		</tr>
		<tr>
			<td class="c666">公司：</td>
			<td colspan="3">${company}</td>
		</tr>
		<tr>
			<td class="c666">地址：</td>
			<td colspan="3"></td>
		</tr>
		<tr>
			<td class="c666">联系电话：</td>
			<td colspan="3"></td>
		</tr>
		<tr>
			<td class="c666">发货人开户银行：</td>
			<td colspan="3"></td>
		</tr>
		<tr>
			<td class="c666">发货人收款账户名：</td>
			<td colspan="3"></td>
		</tr>
		<tr>
			<td class="c666">SWIFT Code：</td>
			<td colspan="3"></td>
		</tr>
		<tr>
			<td class="c666">收款人账号：</td>
			<td colspan="3"></td>
		</tr>
		<tr>
			<td colspan="4" class="people">收货人（全称和地址）<p class="entxt"></p></td>
		</tr>
		<tr>
			<td class="c666">公司：</td>
			<td colspan="3"></td>
		</tr>
		<tr>
			<td class="c666">地址：</td>
			<td colspan="3"></td>
		</tr>
		<tr>
			<td class="c666">联系电话：</td>
			<td colspan="3"></td>
		</tr>
	</table>
	<table id="order-table" class="order-table">
		<tr>
			<th class="widthT">序号</th>
			<th>货物采购单号</th>
			<th>日期</th>
			<th>总价</th>
		</tr>
<#--	<#list productInfoList as value>-->
<#--		<tr>-->
<#--			<td>${value_index+1}</td>-->
<#--			<td>${value.orderNo}</td>-->
<#--			<td>${value.date}</td>-->
<#--			<td>${value.totalAmount}</td>-->
<#--		</tr>-->
<#--	</#list>-->
	</table>
	<table class="foot-table">
		<tr>
			<td width="150px">发票总金额:　<span class="sum">USD <b></b></span>
			<span class="gz">发货人签字、盖章:</span>
			</td>
		</tr>
	</table>
</div>
<script>
function addClass(element, value) {//element:需要添加新样式的元素，value：新的样式
  if (!element.className) {
    element.className = value;
  } else {
    newClassName = element.className;
    newClassName += " ";
    newClassName += value;
    element.className = newClassName;
  }
}
function stripeTable(){
  //if(!document.getElementById("order-table")) return false;
  /*获取table*/
  var table = document.getElementById("order-table");
  /*遍历 为所有表格添加*/
  //for(var i=0;i<table.length;i++){
    /*判断是否为奇数行
    * 将第一行设置成true
    * */
    var odd = true;
    var tr = table.getElementsByTagName("tr");
    /*遍历表格中的每一行*/
    for(var j=0;j<tr.length;j++){
      if(odd){
        addClass(tr[j],"stripe");
        /*将下一行设置称false*/
        odd = false;
      }else{
        /*将下一行设置称true*/
        odd = true;
      }
    }
  //}
}
stripeTable()
</script>
</body>
</html>
