mui.init();
var gId = $.getUrlVars()['gId'];
var itemId = 0;
var goodItems = 0;

//商品信息初始化
function initData(data){
	var content = JSON.parse(data.good.content);
	$("#goodImage").attr("src",staticURL+data.good.imageUrl);
	$("#goodName").text(data.good.goodsName);
	$("#goodPrice").text("$ "+data.good.goodsPrice);
	$("#brand").text(data.good.brand);
	$("#num").text(data.good.goodsStock);
	$("#type").text(content.type);
	$("#material").text(content.material);
	for(var i =0;i<content.imgDetails.length;i++){
		$("#goodDetial").append('<img src="'+staticURL+content.imgDetails[i]+'" />')
	}
	//蒙版DIV事件绑定
	$(".maskStyle").on('tap',function(){
		$(".maskStyle").hide();
		$(".itemOutter").hide();
	});
	
	//加入购物车事件绑定
	$("#addToCart").on('tap',function(){
        var uId=storage.getItem('uid');
        if(uId!=null&&uId!=''){
            var url = hostURL+"/cart/addToCart";

            if(itemId==0){
                //未选择任何颜色型号
                showOrHideItems();
            }else{
                //已选择颜色型号
                $.ajax({
                    type:"post",
                    url:url,
                    data:'userId='+uId+'&goodsId='+gId+'&itemId='+itemId,
                    dataType:'text',
                    success:function(d){
                        if(d==0){
                            mui.toast('加入购物车失败');
                        }else{
                            mui.toast('加入购物车成功');
                        }
                    }
                });
                //加入购物车完成，将选择的颜色型号清除，关闭颜色DIV
                itemId = 0;
                showOrHideItems();
            }
		}else{
            mui.toast('请先登陆！');
            setInterval('refresh()',1000)
		}

	});
}

function refresh() {
    window.location.href='login.html'

}
//商品颜色尺码信息初始化
function initItems(data){
	var $itemList = $("#colorItemList");
	console.log(data)
	$.each(data, function(index,item) {
		$itemList.append('<li><span>'+item.itemName+'</span><p id="itemId">'+item.itemId+'</p><p id="itemNum">'+item.num+'</p></li>');
	});
	//选择颜色事件绑定
	$("#colorItemList li").on('tap',function(){
		$("#colorItemList li").removeClass('checked');
		$(this).addClass('checked');
		if($("#colorItemList li").is(".checked")){
			itemId = $("#colorItemList .checked").find("#itemId").text();
			$("#productNum").find('p').find('span').text($("#colorItemList .checked").find("#itemNum").text());
			$("#productNum").removeAttr("hidden");
		}
	});
	
}
//显示颜色选择部分DIV
function showOrHideItems(){
	var $node = $(".itemOutter");
	if($node.is(":hidden")){
		$(".maskStyle").show();
		$node.show();
	}else{
		$(".maskStyle").hide();
		$node.hide();
	}
}

function cart(){
	window.location.href="cart.html";
}

function home(){
	window.location.href="index.html";
}

$(function(){
	$.ajax({
		url:hostURL+"/goods/showGood",
		data:'gId='+gId,
		dataType:'json',
		type:'post',
		success:function(data){
			initData(data);
			console.log(data.good.goodsitems)
			initItems(data.good.goodsitems);
		}
	});
});
